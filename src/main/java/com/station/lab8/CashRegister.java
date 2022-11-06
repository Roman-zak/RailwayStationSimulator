package com.station.lab8;

import org.apache.commons.lang3.NotImplementedException;

import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CashRegister implements ICashRegister, Runnable{
    private static Logger logger = Logger.getLogger(CashRegister.class.getName());
    private static int serviceTime;
    private PriorityQueue<ICustomer> queue;
    private int entrancesCount;
    private boolean serviceable;
    private boolean reserved;

    public CashRegister() {
    }

    public CashRegister(PriorityQueue<ICustomer> queue, int entrancesCount, boolean serviceable, boolean reserved) {
        this.queue = queue;
        this.entrancesCount = entrancesCount;
        this.serviceable = serviceable;
        this.reserved = reserved;
    }

    public static int getServiceTime() {
        return serviceTime;
    }

    public static void setServiceTime(int serviceTime) {
        CashRegister.serviceTime = serviceTime;
    }

    public PriorityQueue<ICustomer> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<ICustomer> queue) {
        this.queue = queue;
    }

    public int getEntrancesCount() {
        return entrancesCount;
    }

    public void setEntrancesCount(int entrancesCount) {
        this.entrancesCount = entrancesCount;
    }

    public boolean isServiceable() {
        return serviceable;
    }

    public void setServiceable(boolean serviceable) {
        this.serviceable = serviceable;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public void serve() {
        logger.log(Level.INFO,"serving customer");
        throw new NotImplementedException();
    }

    @Override
    public void makeBreak() {
        throw new NotImplementedException();
    }

    @Override
    public void run() {
        throw new NotImplementedException();
    }
}
