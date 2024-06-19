package com.java.designPatterns.designPatterns.memento.objectHistory;

/**
 * Created by anekkumarsingh on 2024-06-19 at 11:30:14
 */
public class MainApplication {
    public static void main(String[] args) {

        /* Create Care Taker */
        ConfigurationCareTaker careTaker = new ConfigurationCareTaker();

        /* Create State Object 1 */
        State state1 = new State();
        state1.setName("Anek");
        state1.setComment("commit-1");

        /* Create Originator */
        ConfigurationOriginator originator = new ConfigurationOriginator();
        System.out.println("changing state of originator to state 1");
        originator.setState(state1);

        /* Create Memento */
        ConfigurationMemento snapshot1 = originator.createMemento();
        careTaker.addMemento(snapshot1);

        /* Create State Object 2 */
        State state2 = new State();
        state2.setName("Vicky");
        state2.setComment("commit-2");

        // change the state of originator
        System.out.println("changing state of originator to state 2");
        originator.setState(state2);

        ConfigurationMemento snapshot2 = originator.createMemento();
        careTaker.addMemento(snapshot2);

        careTaker.showHistory().forEach(System.out::println);


        /* Create State Object 3 */
        State state3 = new State();
        state3.setName("Mishita");
        state3.setComment("commit-3");

        // change the state of originator
        System.out.println("******* changing state of originator to state 3");
        originator.setState(state3);

        System.out.println("******* Undo to state 2");

       ConfigurationMemento restoreMemento = careTaker.undo();
       originator.restoreMemento(restoreMemento);
        System.out.println("restored :"+originator);
    }
}









