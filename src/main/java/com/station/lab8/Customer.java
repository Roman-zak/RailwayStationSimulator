package com.station.lab8;

public class Customer implements ICustomer{
    private int ticketsCount;
    private CustomerStatus status;
    private Entrance entrance;

    public Customer() {
    }

    public Customer(int ticketsCount, CustomerStatus status, Entrance entrance) {
        this.ticketsCount = ticketsCount;
        this.status = status;
        this.entrance = entrance;
    }

    @Override
    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
    }
    @Override
    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    @Override
    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }


    public int getTicketsCount() {
        return ticketsCount;
    }
    public CustomerStatus getStatus() {
        return status;
    }
    public Entrance getEntrance() {
        return entrance;
    }

}
