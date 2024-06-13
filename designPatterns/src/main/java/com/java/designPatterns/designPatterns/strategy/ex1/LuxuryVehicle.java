package com.java.designPatterns.designPatterns.strategy.ex1;

/**
 * Created by anekkumarsingh on 2024-06-13 at 10:48:23
 */
public class LuxuryVehicle extends Vehicle{

    LuxuryVehicle(IDriveStrategy driveStrategy){
        super(driveStrategy);
    }
}
