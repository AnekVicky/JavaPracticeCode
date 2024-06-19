package com.java.designPatterns.designPatterns.memento.objectHistory;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by anekkumarsingh on 2024-06-19 at 11:22:48
 */
@ToString
@Getter
public class ConfigurationMemento {

    private State state;

    public ConfigurationMemento(State state){
        this.state = state;
    }

}
