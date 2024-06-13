package com.java.designPatterns.designPatterns.strategy.ex1;

/**
 * Created by anekkumarsingh on 2024-06-13 at 10:48:04
 */
public class SportsVehicle extends Vehicle{

    SportsVehicle(IDriveStrategy driveStrategy){
        super(driveStrategy);
    }
}
