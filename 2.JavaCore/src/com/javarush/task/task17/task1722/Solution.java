package com.javarush.task.task17.task1722;

/* 
Посчитаем
*/



import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

       // System.out.println(Arrays.toString(values));

        counter1.start();
        counter1.join();
       // System.out.println(Arrays.toString(values));

        counter2.start();
        counter2.join();

        counter3.start();
        counter3.join();

        counter4.start();
        counter4.join();
     //   System.out.println(Arrays.toString(values));

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 1;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (values) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}
