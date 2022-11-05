package com.station.lab8;

public interface ICashRegister {
    void serve();
    void makeBreak();
    boolean isServiceable();
    boolean isReserved();
}
