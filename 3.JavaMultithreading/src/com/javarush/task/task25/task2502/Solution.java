package com.javarush.task.task25.task2502;


import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws IllegalArgumentException {
            //init wheels here

               wheels = new ArrayList<>();
               String [] wheelsCar =loadWheelNamesFromDB();
            if (wheelsCar.length!=4 || wheelsCar==null)
                throw new IllegalArgumentException();
               for (String wheel : wheelsCar) {

                  wheels.add(Wheel.valueOf(wheel));
               }

        }
        public  void printCar(){
            for (Wheel wheel : wheels){
                System.out.println(wheel);
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }


    }

    public static void main(String[] args) throws  IllegalArgumentException{
        Solution.Car solution = new Car();
        solution.printCar();
    }


}
