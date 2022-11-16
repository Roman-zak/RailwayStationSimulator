package com.station.lab8;

import javafx.geometry.Pos;
import org.apache.commons.lang3.NotImplementedException;

import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CashRegister implements ICashRegister{
    private static Logger logger = Logger.getLogger(CashRegister.class.getName());
    private static int serviceTime=1000;


    private PriorityQueue<ICustomer> queue;
    private boolean serviceable;
    private boolean reserved;
    private Position position;

    public CashRegister() {
    }
    public  CashRegister(Position position){
        this(new PriorityQueue<>(),true, false,position);
    }

    public CashRegister(PriorityQueue<ICustomer> queue, boolean serviceable, boolean reserved, Position position) {
        this.queue = queue;

        this.serviceable = serviceable;
        this.reserved = reserved;
        this.position = position;
    }

    public  int getServiceTime() {
        return serviceTime;
    }

    public  void setServiceTime(int serviceTime) {
        CashRegister.serviceTime = serviceTime;
    }

    public PriorityQueue<ICustomer> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<ICustomer> queue) {
        this.queue = queue;
    }

    public boolean isServiceable() {
        return serviceable;
    }
    @Override
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
        this.queue.poll();
    }
    @Override
    public void addCustomer(Customer customer){
        this.queue.add(customer);
    }

    @Override
    public synchronized void  makeBreak() {
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
