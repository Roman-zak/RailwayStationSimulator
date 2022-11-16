package com.station.lab8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;

public class CustomerWrapper {
    SimpleIntegerProperty id;
    SimpleIntegerProperty ticketsCount;
    SimpleObjectProperty<CustomerStatus> status;
    SimpleObjectProperty<Entrance> entrance;

    CustomerWrapper() {
        id = new SimpleIntegerProperty();
        ticketsCount = new SimpleIntegerProperty();
        status = new SimpleObjectProperty<CustomerStatus>();
        entrance = new SimpleObjectProperty<Entrance>();
    }

    CustomerWrapper(Integer id, Integer ticketsCount, CustomerStatus status, Entrance entrance) {
        this.id.set(id);
        this.ticketsCount.set(ticketsCount);
        this.status.set(status);
        this.entrance.set(entrance);
    }

    void setId(Integer id) {
        this.id.set(id);
    }

    void setTicketsCount(Integer ticketsCount) {
        this.ticketsCount.set(ticketsCount);
    }

    void setStatus(CustomerStatus status) {
        this.status.set(status);
    }

    void setEntrance(Entrance entrance) {
        this.entrance.set(entrance);
    }

    Integer getId() {
        return id.get();
    }

    Integer getTicketsCount() {
        return ticketsCount.get();
    }

    CustomerStatus getStatus() {
        return status.get();
    }

    Entrance getEntrance() {
        return entrance.get();
    }

}
