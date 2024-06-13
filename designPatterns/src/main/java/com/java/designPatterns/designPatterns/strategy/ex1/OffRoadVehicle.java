package com.java.designPatterns.designPatterns.strategy.ex1;

/**
 * Created by anekkumarsingh on 2024-06-13 at 10:47:53
 */
public class OffRoadVehicle extends Vehicle{

    OffRoadVehicle(IDriveStrategy driveStrategy){
        super(driveStrategy);
    }
}
