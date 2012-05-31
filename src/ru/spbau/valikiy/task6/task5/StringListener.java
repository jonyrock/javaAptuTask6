package ru.spbau.valikiy.task6.task5;

public class StringListener implements ActionListener{
    
    String msg;
    
    public StringListener(String msg){
        this(msg, false);
    }

    public StringListener(String msg, boolean b){
        if(b){
            System.out.println("Create Listener " + msg + " at ");
        } 
        this.msg = msg;
    }
    
    public void performAction() {
        System.out.println(msg);
    }
}
