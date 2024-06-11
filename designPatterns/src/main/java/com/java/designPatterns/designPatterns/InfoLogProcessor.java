package com.java.designPatterns.designPatterns;

public class InfoLogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(Level level, String message) {

        if(level.equals(Level.INFO)){
            System.out.println(level+"::"+message);
        }else {
            nextLogProcessor(level, message);
        }
    }//
}
