package com.java.designPatterns.designPatterns.chainOfResponsibilities.LogProcessor;
/**
 * Created by anekkumarsingh on 2024-06-11 at 11:48:09
 */
public class InfoLogProcessor extends LogProcessor {

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
