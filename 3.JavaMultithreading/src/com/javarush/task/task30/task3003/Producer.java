package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int n =1;
       try {
           while (n <= 9) {
               ShareItem shareItem = new ShareItem(String.format("ShareItem-%d", n), n);
               System.out.format("Элемент 'ShareItem-%d' добавлен \n", shareItem.itemId);
               queue.offer(shareItem);
               Thread.sleep(100);
               if (queue.hasWaitingConsumer()){
                   System.out.format("Consumer в ожидании!\n");
               }
               n++;
           }
       }catch (InterruptedException o){}


    }
}
