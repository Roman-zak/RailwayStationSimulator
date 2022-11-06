package com.station.lab8;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class Station {
    private static Station instance;
    List<CashRegister> cashRegisters;
    List<Entrance> entrances;
    IQueueResolver queueResolver;
    int capacity;
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
        throw new NotImplementedException();
    }
    public void updateQueues(Customer customer){ //appoint customer to the queue
        queueResolver.appointCustomerToQueue(cashRegisters, customer);
        throw new NotImplementedException();
    }
    public void useReservedCashRegister(ICashRegister stoppedCashRegister){
        throw new NotImplementedException();
    }
}
