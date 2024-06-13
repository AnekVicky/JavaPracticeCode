package com.java.designPatterns.designPatterns.strategy.ex1;

/**
 * Created by anekkumarsingh on 2024-06-13 at 10:46:38
 */
public abstract class Vehicle {

    private IDriveStrategy driveStrategy;

     Vehicle(IDriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        this.driveStrategy.drive();
    }
}
