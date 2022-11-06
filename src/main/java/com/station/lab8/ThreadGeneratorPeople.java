package com.station.lab8;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadGeneratorPeople implements IThreadGeneratorPeople {
    private Strategy generatorStrategy;
    private Station station;
    private List<Entrance> entranceList;

    public ThreadGeneratorPeople(Strategy generatorStrategy, Station station, List<Entrance> entranceList) {
        this.generatorStrategy = generatorStrategy;
        this.station = station;
        this.entranceList = entranceList;
    }

    @Override
    public void setStrategy(Strategy strategy) {
       this.generatorStrategy = strategy;
    }

    @Override
    public void generate() {
        int ticketsCount = ThreadLocalRandom.current().nextInt(1, 11);
        Entrance entrance = this.entranceList.get(ThreadLocalRandom.current().nextInt(0, this.entranceList.size() + 1) - 1);
        CustomerStatus status = CustomerStatus.values()[new Random().nextInt(CustomerStatus.values().length)];
        this.station.updateQueues(new Customer(ticketsCount, status, entrance));
    }

    @Override
    public void run() {
        TimerTask task = new TimerTask() {
            public void run() {
                generate();
            }
        };
        Timer timer = new Timer("PeopleGeneratorTimer");

        long delay = this.generatorStrategy.getInterval();
        timer.schedule(task, delay);
    }
}
