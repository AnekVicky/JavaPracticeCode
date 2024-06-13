package com.java.designPatterns.designPatterns.strategy.ex1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anekkumarsingh on 2024-06-13 at 10:59:13
 */
public class MainApplication {
    public static void main(String[] args) {

        List<Vehicle> vehicles = Arrays.asList(
                new LuxuryVehicle(new SuperSpecialityDriveStrategy()),
                new SportsVehicle(new SuperSpecialityDriveStrategy()),
                new PassengerVehicle(new NormalDriveStrategy()),
                new OffRoadVehicle(new SuperSpecialityDriveStrategy())
        );
        vehicles.forEach(Vehicle::drive);

    }
}
