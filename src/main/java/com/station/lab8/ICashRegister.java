package com.station.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public interface ICashRegister extends Runnable, Comparable {

    void serve();
    void makeBreak();
    boolean isServiceable();
    boolean isReserved();
    PriorityQueue<ICustomer> getQueue();
    Position getPosition();
    void addCustomer(ICustomer customer);
    void setServiceTime(int time);
    int getServiceTime();
    void setServiceable(boolean serviceable);
    void setQueue(PriorityQueue<ICustomer> queue);

}
