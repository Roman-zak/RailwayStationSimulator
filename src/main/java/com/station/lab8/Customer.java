package com.station.lab8;

public class Customer implements ICustomer{
    private int ticketsCount;
    static int IdCount =0;
    private final int id;
    public int getId(){
        return id;
    }
    private CustomerStatus status;
    private Entrance entrance;

    public Customer() {
        id= IdCount;
        IdCount++;
    }

    public Customer(int ticketsCount, CustomerStatus status, Entrance entrance) {
        this();
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


    @Override
    public int getTicketsCount() {
        return ticketsCount;
    }
    @Override
    public CustomerStatus getStatus() {
        return status;
    }
    @Override
    public Entrance getEntrance() {
        return entrance;
    }

    @Override
    public int compareTo(Object o) {
        var cust = (Customer)o;
        int status1 = (status.equals(CustomerStatus.REGULAR))?1:0;
        int status2 =cust.status.equals(CustomerStatus.REGULAR)?1:0;
        if(status1==status2)
            return id>cust.id?1:-1;
        return  status1>status2?1:-1;

    }

    @Override
    public String toString() {
        return status.toString()+" "+status.ordinal()+" "+ticketsCount+" "+id;
    }
}
