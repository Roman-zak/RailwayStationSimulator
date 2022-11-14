package com.station.lab8;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class CashRegisterWrapper {
    private final SimpleStringProperty posX;
    private final SimpleStringProperty posY;
    private final SimpleBooleanProperty isReserved;
    private final SimpleBooleanProperty isServiceable;
    public String positionX;
    public String positionY;
    public Boolean reserved;
    public Boolean serviceable;

    public CashRegisterWrapper(String x, String y, Boolean r, Boolean s){
        this.posX = new SimpleStringProperty(x);
        this.posY = new SimpleStringProperty(y);
        this.isReserved = new SimpleBooleanProperty(r);
        this.isServiceable = new SimpleBooleanProperty(s);
        this.positionX = x;
        this.positionY = y;
        this.reserved = r;
        this.serviceable = s;
    }

    public void setPosX(String x) {
        posX.set(x);
        positionX = x;
    }

    public void setPosY(String y) {
        posX.set(y);
        positionY = y;
    }

    public String getPosX() {
        return posX.get();
    }

    public String getPosY() {
        return posY.get();
    }

    public Boolean getIsReserved(){
        return isReserved.get();
    }

    public void setIsReserved(Boolean r){
        isReserved.set(r);
        reserved = r;
    }

    public Boolean getIsServiceable(){
        return isServiceable.get();
    }

    public void setIsServiceable(Boolean s){
        isServiceable.set(s);
        serviceable = s;
    }
}
