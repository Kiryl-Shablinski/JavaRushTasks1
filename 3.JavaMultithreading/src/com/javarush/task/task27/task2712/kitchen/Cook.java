package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import com.javarush.task.task27.task2712.Restaurant;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Objects;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;


public class Cook extends Observable implements Runnable{
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = Restaurant.getOrderQueue();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  getName();
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        StatisticManager manager = StatisticManager.getInstance();
        CookedOrderEventDataRow cookEvent = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime(),
                order.getDishes());
        manager.register(cookEvent);
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
        setChanged();
        Thread.sleep(order.getTotalCookingTime() * 10L);
        notifyObservers(order);
        busy = false;
    }

    @Override
    public void run() {
        while (true){
            while (!queue.isEmpty()) {
                    if (!isBusy()) {
                        try {
                           startCookingOrder(Objects.requireNonNull(queue.poll()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
