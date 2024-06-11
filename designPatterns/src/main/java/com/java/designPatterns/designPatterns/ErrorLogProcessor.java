package com.java.designPatterns.designPatterns;

public class ErrorLogProcessor {

    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(Level level, String message) {
        if(level.equals(Level.ERROR)){
            System.out.println(level+"::"+message);
        }else{
            super.nextLogProcessor(level, message);
        }
    }
}
