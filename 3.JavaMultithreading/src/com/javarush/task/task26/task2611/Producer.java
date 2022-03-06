package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map){
        this.map = map;
    }


    @Override
    public void run() {
       try {
            Thread currentThread = Thread.currentThread();
            int i=1;

           while (!currentThread.isInterrupted()) {
               int j=i;
             map.putIfAbsent(String.valueOf(i++),"Some text for " + j);
             Thread.sleep(500);

           }
       }catch (InterruptedException o){
           System.out.println(String.format("[%s] thread was terminated",
                   Thread.currentThread().getName()));
       }

    }
}
