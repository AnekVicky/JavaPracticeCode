package com.java.designPatterns.designPatterns.chainOfResponsibilities.ex1;
/**
 * Created by anekkumarsingh on 2024-06-11 at 11:48:09
 */
public class ErrorLogProcessor extends LogProcessor{

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
