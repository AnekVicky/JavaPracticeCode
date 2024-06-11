package com.java.designPatterns.designPatterns.chainOfResponsibilities.ex1;

/**
 * Created by anekkumarsingh on 2024-06-11 at 11:33:51
 */

public abstract class LogProcessor {

    LogProcessor nextLogProcessor ;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public abstract void log(Level level,String message);

    public void nextLogProcessor(Level level,String message){
        this.nextLogProcessor.log(level,message);
    }


}
