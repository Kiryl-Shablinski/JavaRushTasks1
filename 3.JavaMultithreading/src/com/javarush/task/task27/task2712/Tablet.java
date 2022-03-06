package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet  {
    private final int number;
   private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
        setQueue(Restaurant.getOrderQueue());
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void createTestOrder(){
        TestOrder testOrder = null;
        try{
            testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            if (!testOrder.isEmpty()) {
               // setChanged();
               // notifyObservers(testOrder);
                queue.put(testOrder);
                AdvertisementManager manager = new AdvertisementManager(testOrder.getTotalCookingTime()*60);
                manager.processVideos();
            }

        }catch (IOException o) {
            logger.severe("Console is unavailable.");
        }catch (NoVideoAvailableException o){
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
        }
    }

    public Order createOrder(){
        Order order = null;
        try{
          order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
              //  setChanged();
              //  notifyObservers(order);
                queue.put(order);
                AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime()*60);
                manager.processVideos();
            }

        }catch (IOException o) {
            logger.severe("Console is unavailable.");
        }catch (NoVideoAvailableException o){
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;

    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
