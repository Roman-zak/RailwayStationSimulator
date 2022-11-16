package com.station.lab8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomerWrapper {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty ticketsCount;
    private final SimpleObjectProperty<CustomerStatus> status;
    private final SimpleStringProperty entrance;

    CustomerWrapper() {
        id = new SimpleIntegerProperty();
        ticketsCount = new SimpleIntegerProperty();
        status = new SimpleObjectProperty<CustomerStatus>();
        entrance = new SimpleStringProperty();
    }

    CustomerWrapper(Integer id, Integer ticketsCount, CustomerStatus status, String entrance) {
        this();
        this.id.set(id);
        this.ticketsCount.set(ticketsCount);
        this.status.set(status);
        this.entrance.set(entrance);
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public void setTicketsCount(Integer ticketsCount) {
        this.ticketsCount.set(ticketsCount);
    }

    public void setStatus(CustomerStatus status) {
        this.status.set(status);
    }

    public void setEntrance(String entrance) {
        this.entrance.set(entrance);
    }

    public Integer getId() {
        return id.get();
    }

    public Integer getTicketsCount() {
        return ticketsCount.get();
    }

    public CustomerStatus getStatus() {
        return status.get();
    }

    public String getEntrance() {
        return entrance.get();
    }

}