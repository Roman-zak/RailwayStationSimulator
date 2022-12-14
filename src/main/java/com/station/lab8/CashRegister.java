package com.station.lab8;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CashRegister implements ICashRegister{

    private static int serviceTime=1000;

    public static List<ILogger> loggers = new ArrayList<>();
    private PriorityQueue<ICustomer> queue;

    private boolean serviceable;
    private boolean reserved;
    private Position position;

    public CashRegister() {
    }
    public CashRegister(Position position, boolean serviceable, boolean reserved) {
        this(new PriorityQueue<>(),serviceable, reserved,position);
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

    @Override
    public  int getServiceTime() {
        return serviceTime;
    }

    public  void setServiceTime(int serviceTime) {
        CashRegister.serviceTime = serviceTime;
    }

    public PriorityQueue<ICustomer> getQueue() {
        return queue;
    }

    @Override
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

    public static void setLoggers(ArrayList<ILogger> logs){loggers = logs;}
    @Override
    public void serve() {

        var custToRemove = this.queue.peek();
        loggers.forEach(l->l.log(String.format("%d Served by station(reserved %s) with position x:%d y%d: give %d tickets"
                ,custToRemove.getId(), reserved, custToRemove.getEntrance().getPosition().getX(),
                custToRemove.getEntrance().getPosition().getY(), custToRemove.getTicketsCount())));
        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(this.queue.peek().getTicketsCount() > 1){
            this.queue.peek().setTicketsCount(this.queue.peek().getTicketsCount() - 1);
        }
        else{
            this.queue.poll();
        }

    }
    @Override
    public void addCustomer(ICustomer customer){
        this.queue.add(customer);

    }

    @Override
    public synchronized void  makeBreak() {
        this.serviceable = false;
    }

    @Override
    public void run() {
        while(serviceable){
            System.out.println(queue.isEmpty());
            if (!queue.isEmpty()) {
                this.serve();
            }
            System.out.println(this.serviceable);
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
