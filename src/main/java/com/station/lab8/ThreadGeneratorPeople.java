package com.station.lab8;

import org.apache.commons.lang3.NotImplementedException;

public class ThreadGeneratorPeople implements IThreadGeneratorPeople {
    private Strategy generatorStrategy;

    @Override
    public void setStrategy(Strategy strategy) {
       throw new NotImplementedException();
    }

    @Override
    public void generate() {
        throw new NotImplementedException();

    }

    @Override
    public void run() {
        //call generate()
        throw new NotImplementedException();

    }
}
