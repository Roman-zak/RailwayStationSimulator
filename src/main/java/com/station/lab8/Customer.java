package com.station.lab8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer implements ICustomer {
    private final SimpleIntegerProperty posX = new SimpleIntegerProperty();
    private final SimpleIntegerProperty posY = new SimpleIntegerProperty();
    private final SimpleIntegerProperty countTickets = new SimpleIntegerProperty();
    private final SimpleIntegerProperty curId = new SimpleIntegerProperty();

    private int ticketsCount;
    static int IdCount = 0;
    private final int id;

    public int getId() {
        return id;
    }

    private CustomerStatus status;
    private Entrance entrance;

    public Customer() {
        id = IdCount;
        IdCount++;
        curId.set(id);
    }

    public Customer(int ticketsCount, CustomerStatus status, Entrance entrance) {
        this();
        this.ticketsCount = ticketsCount;
        this.status = status;
        this.entrance = entrance;

        countTickets.set(ticketsCount);
        posX.set(entrance.getPosition().getX());
        posY.set(entrance.getPosition().getY());
    }

    public Integer getPosX() {
        return posX.get();
    }

    public Integer getPosY() {
        return posY.get();
    }

    public Integer getCountTickets() {
        return countTickets.get();
    }

    public Integer getCurId() {
        return curId.get();
    }

    @Override
    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
        countTickets.set(ticketsCount);
    }

    @Override
    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    @Override
    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
        posX.set(entrance.getPosition().getX());
        posY.set(entrance.getPosition().getY());
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
        var cust = (Customer) o;
        int status1 = (status.equals(CustomerStatus.REGULAR)) ? 1 : 0;
        int status2 = cust.status.equals(CustomerStatus.REGULAR) ? 1 : 0;
        if (status1 == status2)
            return id > cust.id ? 1 : -1;
        return status1 > status2 ? 1 : -1;
    }

    @Override
    public String toString() {
        return status.toString() + " " + status.ordinal() + " " + ticketsCount + " " + id;
    }
}
