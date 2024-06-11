package com.java.designPatterns.designPatterns;

public class DebugLogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(Level level, String message) {
        if(level.equals(Level.DEBUG)){
            System.out.println(level+"::"+message);
        }else{
            super.nextLogProcessor(level, message);
        }
    }
}
