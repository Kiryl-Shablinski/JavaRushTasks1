package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
   private static final int ORDER_CREATING_INTERVAL = 100;
   private final static LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        Cook cook = new Cook("Kiryl");
        Cook cook1 = new Cook("Amigo");
       
        Waiter waiter = new Waiter();
        StatisticManager manager = StatisticManager.getInstance();
       // manager.register(cook);
       // manager.register(cook1);

        List<Tablet> tablets = new ArrayList<>(5);
        for (int i=0; i<5; i++){
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
          //  tablet.addObserver(orderManager);
            Thread thread =new Thread(cook);
            Thread thread1 = new Thread(cook1);
            thread.start();
            thread1.start();
            cook.addObserver(waiter);
            cook1.addObserver(waiter);

        }

        RandomOrderGeneratorTask randomTask = new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL);
        Thread orderThread = new Thread(randomTask);
        orderThread.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException o){

        }
        orderThread.interrupt();


        DirectorTablet director = new DirectorTablet();
        director.printAdvertisementProfit();
        director.printCookWorkloading();
        director.printActiveVideoSet();
        director.printArchivedVideoSet();


    }

    public static LinkedBlockingQueue<Order> getOrderQueue() {
        return ORDER_QUEUE;
    }
}
