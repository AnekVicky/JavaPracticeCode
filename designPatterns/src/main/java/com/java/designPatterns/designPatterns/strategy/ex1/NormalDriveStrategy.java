package com.java.designPatterns.designPatterns.strategy.ex1;

/**
 * Created by anekkumarsingh on 2024-06-13 at 12:58:15
 */
public class NormalDriveStrategy implements IDriveStrategy{
    @Override
    public void drive() {
        System.out.println("This is Normal Drive Strategy");
    }
}
