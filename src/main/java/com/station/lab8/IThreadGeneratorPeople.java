package com.station.lab8;

public interface IThreadGeneratorPeople extends Runnable {

    void setStrategy(Strategy strategy);
    void generate();

    Boolean isGenerating();
    void stopGeneration();

}
