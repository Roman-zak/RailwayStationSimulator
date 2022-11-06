package com.station.lab8;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerateStrategy implements Strategy {

    private int lowerBound;
    private int upperBound;

    public RandomGenerateStrategy(int lowerBound, int upperBound){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    @Override
    public int getInterval() {
        return ThreadLocalRandom.current().nextInt(this.lowerBound, this.upperBound + 1);
    }
}
