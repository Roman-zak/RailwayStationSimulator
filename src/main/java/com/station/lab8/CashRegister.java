package com.station.lab8;

import javafx.geometry.Pos;
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

    private Position position;

    public CashRegister() {
    }

    public CashRegister(PriorityQueue<ICustomer> queue, int entrancesCount, boolean serviceable, boolean reserved, Position position) {
        this.queue = queue;
        this.entrancesCount = entrancesCount;
        this.serviceable = serviceable;
        this.reserved = reserved;
        this.position = position;
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
        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.queue.remove(this.queue.peek());
    }

    public void addCustomer(Customer customer){
        this.queue.add(customer);
    }

    @Override
    public void makeBreak() {
        this.serviceable = false;
    }

    @Override
    public void run() {
        while(serviceable){
            if (!queue.isEmpty()) {
                this.serve();
            }
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
