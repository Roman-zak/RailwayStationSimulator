package com.station.lab8;

import javafx.collections.ObservableList;

import java.util.Random;

public class TableLogger implements ILogger {

    ObservableList<LogWrapper> logs;
    public  TableLogger( ObservableList<LogWrapper> logs){
        this.logs = logs;
    }

    static Random random = new Random();
    @Override
    public void log(String msg) {
        var endIndex = msg.indexOf(' ');
        logs.add(new LogWrapper(random.nextInt(10000) ,msg.substring(endIndex,msg.length()) ));

    }
}
