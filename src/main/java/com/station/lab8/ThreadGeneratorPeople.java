package com.station.lab8;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadGeneratorPeople implements IThreadGeneratorPeople {

    public int minTicket=1;
    public  int maxTicket=11;

    Boolean generating;
    Station station = Station.getInstance();
    Strategy strategy ;
    public ThreadGeneratorPeople(Strategy generatorStrategy) {
        this.strategy = generatorStrategy;
    }
    @Override
    public Boolean isGenerating(){return generating;}
    @Override
    public  void stopGeneration(){
        synchronized (generating){
            generating = false;
        }
    }
    @Override
    public void setStrategy(Strategy strategy) {
       this.strategy = strategy;
    }

    @Override
    public void generate() {
        int ticketsCount = ThreadLocalRandom.current().nextInt(minTicket, maxTicket);
        Entrance entrance = station.getEntrances().get(ThreadLocalRandom.current().nextInt(0, station.getEntrances().size()) );
        CustomerStatus status = CustomerStatus.values()[new Random().nextInt(CustomerStatus.values().length)];
        this.station.updateQueues(new Customer(ticketsCount, status, entrance));
    }

    @Override
    public void run() {
        generating = true;
        while (true){
            synchronized (generating){
                if(!generating)
                    return;
            }
            generate();
            try {
                Thread.sleep(strategy.getInterval());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /*
        TimerTask task = new TimerTask() {
            public void run() {
                generate();
            }
        };
        Timer timer = new Timer("PeopleGeneratorTimer");

        long delay = this.strategy.getInterval();
        timer.schedule(task, delay);*/

    }
}
