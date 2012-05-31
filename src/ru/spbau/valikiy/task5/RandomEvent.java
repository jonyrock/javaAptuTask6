package ru.spbau.valikiy.task5;

import java.util.Random;

/**
 * 50% than event will be fired
 */
public class RandomEvent extends Event{
    /**
     * ready or not
     * @return either true or false
     */
    @Override
    public boolean ready() {
        return new Random().nextBoolean();
    }
}
