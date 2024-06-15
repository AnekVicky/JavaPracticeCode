package com.java.designPatterns.designPatterns.chainOfResponsibilities.LogProcessor;
/**
 * Created by anekkumarsingh on 2024-06-11 at 11:48:09
 */
public enum Level {
    INFO("info"),DEBUG("debug"),ERROR("error");

    private String value;

     Level(String s){
        this.value = s;
    }
}
