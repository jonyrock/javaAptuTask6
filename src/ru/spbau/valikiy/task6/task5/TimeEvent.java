package ru.spbau.valikiy.task6.task5;

import java.util.Calendar;

/**
 *
 */
public class TimeEvent extends Event {

    long lastOn;
    long nextOn;

    public TimeEvent() {
        lastOn = Calendar.getInstance().getTimeInMillis();
        nextOn = lastOn + 10000;
    }

    @Override
    public boolean ready() {
        return Calendar.getInstance().getTimeInMillis() >= nextOn;
    }


}
