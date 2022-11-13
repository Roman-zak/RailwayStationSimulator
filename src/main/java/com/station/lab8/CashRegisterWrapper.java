package com.station.lab8;

public class CashRegisterWrapper {
    public String positionX;
    public String positionY;
    public Boolean reserved;
    public Boolean serviceable;

    public CashRegisterWrapper(String x, String y, Boolean r, Boolean s){
        this.positionX = x;
        this.positionY = y;
        this.reserved = r;
        this.serviceable = s;
    }
}
