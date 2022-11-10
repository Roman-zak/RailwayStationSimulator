package com.station.lab8;

public interface ICustomer {
    void setTicketsCount(int ticketsCount);
    void setStatus(CustomerStatus status);
    void setEntrance(Entrance entrance);
    int getTicketsCount();
    public CustomerStatus getStatus();
    public Entrance getEntrance();
}
