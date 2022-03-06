package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge{

    private static int carsCount;

   @Override
    public int getCarsCount(){
       carsCount=30;
        return carsCount;
    }
}
