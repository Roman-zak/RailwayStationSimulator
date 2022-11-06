package com.station.lab8;

public interface IThreadGeneratorPeople extends Runnable {
    Station station = Station.getInstance();
    Strategy strategy = null;
    void setStrategy(Strategy strategy);
    void generate();
}
