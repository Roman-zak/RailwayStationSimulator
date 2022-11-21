package com.station.lab8;

import java.util.List;
import java.util.PriorityQueue;

public class Station {
  //  private static Station instance;

    public void setCashRegisters(List<ICashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    public List<ICashRegister> getCashRegisters() {
        return cashRegisters;
    }

    private List<ICashRegister> cashRegisters;

    public List<Entrance> getEntrances() {
        return entrances;
    }

    private List<Entrance> entrances;
    private IQueueResolver queueResolver;
    private int capacity;
    private int currentPeopleCount;

    private Station(){

    }

    public  Station(List<Entrance> entrances, List<ICashRegister> cashRegisters,
                    IQueueResolver queueResolver, int capacity){
        this.cashRegisters = cashRegisters;
        this.entrances = entrances;
        this.queueResolver = queueResolver;
        this.capacity = capacity;
    }
    /*
    public static Station getInstance(){
        if (instance != null) {
            return instance;
        }
        synchronized(Station.class) {
            if (instance == null) {
                instance = new Station();
            }
            return instance;
        }
    }
    */

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentPeopleCount() {
        int countCashes = cashRegisters.size();
        int countPeople =0;
        for( int i=0;i<countCashes;++i){
            countPeople+= cashRegisters.get(i).getQueue().size();
        }
        currentPeopleCount = countPeople;
        return currentPeopleCount;
    }

    public boolean isFull(){
        getCurrentPeopleCount();
        return currentPeopleCount >= capacity;
    }
    public void updateQueues(ICustomer customer){
        queueResolver.getPosition(cashRegisters,customer.getEntrance().getPosition()).addCustomer(customer);

    }
    public void useReservedCashRegister(ICashRegister stoppedCashRegister){
        if(!stoppedCashRegister.isServiceable())
            return;
        stoppedCashRegister.makeBreak();

        var reservedCashRegister = this.cashRegisters.stream().filter(c -> c.isReserved()&&!c.isServiceable()).findFirst().orElse(null);

        if(reservedCashRegister==null){
            var queue = stoppedCashRegister.getQueue();
            queue.forEach(q->updateQueues(q));
            return;
        }



        reservedCashRegister.setQueue( stoppedCashRegister.getQueue());
        reservedCashRegister.setServiceable(true);

        new Thread(reservedCashRegister).start();
    }

    public void startWork(){
        cashRegisters.forEach(x->new Thread(x).start());
    }

    public void endWork(){
        cashRegisters.forEach(c->c.setServiceable(false));
    }
}
