package ru.spbau.valikiy.task6.task5;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {

    List<ActionListener> listeners = new ArrayList<ActionListener>();

    public abstract boolean ready();

    public void fireEvent() {
        for (ActionListener listener : listeners) {
            listener.performAction();
        }
    }

    public void addListener(ActionListener actionListener) {
        listeners.add(actionListener);
    }

    public void checkState() {
        if (ready()) {
            fireEvent();
        }
    }


}
