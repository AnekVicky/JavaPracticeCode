package com.java.designPatterns.designPatterns.memento.objectHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anekkumarsingh on 2024-06-19 at 11:23:35
 */
public class ConfigurationCareTaker {

    private List<ConfigurationMemento> objHistory = new ArrayList<>(1);

    public void addMemento(ConfigurationMemento memento){
        this.objHistory.add(memento);
    }

    public List<ConfigurationMemento> showHistory(){
        return this.objHistory;
    }
    public ConfigurationMemento undo(){

        if(!objHistory.isEmpty()){
            int lastMementoIndex = objHistory.size() - 1;
            ConfigurationMemento memento = objHistory.get(lastMementoIndex);
            objHistory.remove(lastMementoIndex);
            return memento;
        }
      return null;
    }

}
