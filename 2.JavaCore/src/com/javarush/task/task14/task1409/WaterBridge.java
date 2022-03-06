package com.javarush.task.task14.task1409;

public class WaterBridge implements Bridge{

    private static int carsCount;
    @Override
    public int getCarsCount() {

         carsCount=68;

        return carsCount;
    }
}
