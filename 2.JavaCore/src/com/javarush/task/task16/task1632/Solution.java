package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
       threads.add(new ThreadOne());
       threads.add(new ThreadTwo());
       threads.add(new ThreadThree());
       threads.add(new ThreadFour());
       threads.add(new ThreadFive());

    }

    public static void main(String[] args) {
        for (int i=0; i<threads.size();i++){
            threads.get(i).start();
        }

    }

    public static class ThreadOne extends Thread{

        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class ThreadTwo extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException o){
                System.out.println("InterruptedException");
            }

        }
    }

    public static class ThreadThree extends Thread{

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ThreadFour extends Thread implements Message{
        @Override
        public void showWarning() {
           if(this.isAlive()) this.interrupt();


        }

        @Override
        public void run() {
            while (!interrupted()){

            }
        }
    }
    public static class ThreadFive extends Thread{

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        private String text;
        private int sum=0;
        @Override
        public void run() {
        try{
           while(!isInterrupted()) {
               text=bufferedReader.readLine();
               if (text.equals("N")) this.interrupt();
               else{
               int number = Integer.parseInt(text);
               sum+= number;
               }
           }
            System.out.println(sum);

        }catch (IOException o){



        }

        }
    }
}