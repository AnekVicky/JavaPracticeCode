package com.java.designPatterns.designPatterns;

public enum Level {
    INFO("info"),DEBUG("debug"),ERROR("error");

    private String value;

     Level(String s){
        this.value = s;
    }
}
