package com.java.designPatterns.designPatterns.memento.objectHistory;

import lombok.ToString;

/**
 * Created by anekkumarsingh on 2024-06-19 at 11:21:41
 */
@ToString
public class ConfigurationOriginator {

    private State state;

    public void setState(State state) {
        this.state = state;
    }
    public ConfigurationMemento createMemento(){
        return new ConfigurationMemento(this.state);
    }
    public ConfigurationOriginator restoreMemento(ConfigurationMemento memento){
         setState(memento.getState());
         return this;
    }


}
