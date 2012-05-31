package ru.spbau.valikiy.task5;

/**
 * Listener with message
 */
public class StringListener implements ActionListener{
    
    String msg;

    /**
     * 
     * @param msg to show
     */
    public StringListener(String msg){
        this(msg, false);
    }

    /**
     * 
     * @param msg to show
     * @param b show or not creation time
     */
    public StringListener(String msg, boolean b){
        if(b){
            System.out.println("Create Listener " + msg + " at ");
        } 
        this.msg = msg;
    }

    /**
     * react to event
     */
    public void performAction() {
        System.out.println(msg);
    }
}
