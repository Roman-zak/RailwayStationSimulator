package com.station.lab8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLogger implements ILogger{
    private static Logger logger = Logger.getLogger(CashRegister.class.getName());
    @Override
    public void log(String msg) {

        logger.log(Level.INFO, msg);
    }
}
