package ru.spbau.valikiy.task6.task5;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {

    List<ActionListener> listeners = new ArrayList<ActionListener>();

    abstract boolean ready();

    void fireEvent() {
        if (!ready())
            return;
        for (ActionListener listener : listeners) {
            listener.performAction();
        }
    }

    void addListener(ActionListener actionListener) {
        listeners.add(actionListener);
    }
}
