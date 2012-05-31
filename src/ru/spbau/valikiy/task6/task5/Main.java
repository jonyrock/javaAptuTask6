package ru.spbau.valikiy.task6.task5;

/**
 * Start class
 */
public class Main {

    static TimeEvent timeEvent = new TimeEvent();
    static RandomEvent randomEvent = new RandomEvent();

    /**
     * Start point
     *
     * @param args filename to update avgGrade or nothing to create example
     */
    public static void main(String[] args) {

        addAnonymous();
        add5msg();

        for (int i = 0; i < 15; i++) {
            randomEvent.checkState();
        }

    }

    static void addAnonymous() {
        timeEvent.addListener(new ActionListener() {
            public void performAction() {
                System.out.println("Yohoho handler knows about timeEvent");
            }
        });

        timeEvent.addListener(new ActionListener() {
            public void performAction() {
                System.out.println("AHahaha handler knows about timeEvent");
            }
        });

        randomEvent.addListener(new ActionListener() {
            public void performAction() {
                System.out.println("OMg. It's random.");
            }
        });

        randomEvent.addListener(new ActionListener() {
            public void performAction() {
                System.out.println("I've heard about random!");
            }
        });

    }

    static void add5msg() {
        for (int i = 0; i < 5; i++) {
            timeEvent.addListener(new StringListener("TimeEvent #" + i));
            timeEvent.addListener(new StringListener("TimeEvent #" + i, true));
            randomEvent.addListener(new StringListener("RandomEvent #" + i));
            randomEvent.addListener(new StringListener("RandomEvent #" + i, true));
        }
    }

}
