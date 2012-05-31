package ru.spbau.valikiy.task6.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction for events
 */
public abstract class Event {

    List<ActionListener> listeners = new ArrayList<ActionListener>();

    /**
     * Event ready to be occurred 
     * @return is it true
     */
    public abstract boolean ready();

    /**
     * Emit event
     */
    public void fireEvent() {
        for (ActionListener listener : listeners) {
            listener.performAction();
        }
    }

    /**
     * Add new handler
     * @param actionListener to add
     */
    public void addListener(ActionListener actionListener) {
        listeners.add(actionListener);
    }   


}
