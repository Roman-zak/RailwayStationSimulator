package com.station.lab8;

import java.util.PriorityQueue;

public interface ICashRegister {
    void serve();
    void makeBreak();
    boolean isServiceable();
    boolean isReserved();
    PriorityQueue<ICustomer> getQueue();
}
