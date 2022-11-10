package com.station.lab8;

public class IntervalGenerateStrategy implements Strategy {
    private int interval;
    @Override
    public int getInterval() {
        return interval;
    }

    public IntervalGenerateStrategy(int interval){
        this.interval = interval;
    }
    public void setInterval(int interval) {
        this.interval = interval;
    }
}
