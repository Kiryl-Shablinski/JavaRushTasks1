package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            //Add your code here - добавь код тут
            int countsteps=0;
            try{
                while (true){
                    System.out.println(print(countsteps));
                    Thread.sleep(1000/(rating));
                    countsteps+=1;

                    if (countsteps==OnlineGame.steps.size()) {
                        System.out.println(toWinner(OnlineGame.isWinnerFound));
                        OnlineGame.isWinnerFound=true;
                        return;
                    }
                }
            }catch(InterruptedException o) {
                System.out.println(getName() + ":проиграл");
            }

        }


        public String print(int countsteps) {

            return getName()+":"+OnlineGame.steps.get(countsteps);
        }


        public String toWinner(boolean isWinnerFound) {

            if(isWinnerFound==false){
              return getName() + ":победитель!";
            }

          return getName() + ":проиграл";
        }
    }
}