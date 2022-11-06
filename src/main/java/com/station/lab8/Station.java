package com.station.lab8;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class Station {
    private static Station instance;
    List<CashRegister> cashRegisters;
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
        queueResolver.appointCustomerToQueue(cashRegisters, customer);
    }
    public void useReservedCashRegister(ICashRegister stoppedCashRegister){
        var reservedCashRegister = (CashRegister)this.cashRegisters.stream().filter(c -> c.isReserved());
        stoppedCashRegister.makeBreak();
        reservedCashRegister.setQueue(stoppedCashRegister.getQueue());
    }
}
