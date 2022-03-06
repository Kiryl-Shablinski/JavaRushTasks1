package com.javarush.task.task25.task2506;




public class LoggingStateThread extends Thread{

    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {

        State targetState = target.getState();
        System.out.println(targetState);
       while (target.getState()!=State.TERMINATED){
         if (!(target.getState().equals(targetState))){
             System.out.println(target.getState());
             targetState=target.getState();
         }
       }
        System.out.println(target.getState());

    }
}
