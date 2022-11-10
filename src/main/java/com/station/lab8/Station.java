package com.station.lab8;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class Station {
    private static Station instance;

    public void setCashRegisters(List<ICashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    public List<ICashRegister> getCashRegisters() {
        return cashRegisters;
    }

    List<ICashRegister> cashRegisters;

    public List<Entrance> getEntrances() {
        return entrances;
    }

    List<Entrance> entrances;
    IQueueResolver queueResolver;
    int capacity;
    int currentPeopleCount;
    double criticalFraction; //[0-1]
    private Station(){

    }
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
    public boolean isFull(){
        return currentPeopleCount >= capacity;
    }
    public void updateQueues(Customer customer){
        queueResolver.getPosition(cashRegisters,customer.getEntrance().getPosition()).addCustomer(customer);

    }
    public void useReservedCashRegister(ICashRegister stoppedCashRegister){
        var reservedCashRegister = (CashRegister)this.cashRegisters.stream().filter(c -> c.isReserved());
        stoppedCashRegister.makeBreak();
        reservedCashRegister.setQueue(stoppedCashRegister.getQueue());
    }
}
