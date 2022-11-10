package com.station.lab8;

import java.util.PriorityQueue;

public interface ICashRegister extends Runnable {
    void serve();
    void makeBreak();
    boolean isServiceable();
    boolean isReserved();
    PriorityQueue<ICustomer> getQueue();
    Position getPosition();
    void addCustomer(Customer customer);
    void setServiceTime(int time);
    int getServiceTime();
}
