package ru.spbau.valikiy.task5;

import java.util.Calendar;

/**
 * Event which occurs at most each 10 seconds   
 */
public class TimeEvent extends Event {

    long lastOn;
    long nextOn;

    /**
     * Standard constructor and useful comment
     */
    public TimeEvent() {
        updateTime();
    }

    /**
     * Event ready to be occurred 
     * @return is it true
     */
    @Override
    public boolean ready() {
        return Calendar.getInstance().getTimeInMillis() >= nextOn;
    }

    /**
     * Emit event
     */
    @Override
    public void fireEvent() {
        updateTime();
        super.fireEvent();
    }

    /**
     * Update emission time
     */
    void updateTime() {
        lastOn = Calendar.getInstance().getTimeInMillis();
        nextOn = lastOn + 10000;
    }
    
}
