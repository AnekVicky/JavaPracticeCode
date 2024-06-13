package com.java.designPatterns.designPatterns.strategy.ex1;

/**
 * Created by anekkumarsingh on 2024-06-13 at 12:59:01
 */
public class SuperSpecialityDriveStrategy implements IDriveStrategy{
    @Override
    public void drive() {
        System.out.println("This is a Super Speciality Drive Strategy");
    }
}
