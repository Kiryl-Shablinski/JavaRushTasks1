package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    //10..2
    protected Car(int numberOfPassengers){
        this.numberOfPassengers = numberOfPassengers;
    }

    //10..3
    public static Car create(int type, int numberOfPassengers){

        if (type== TRUCK)   return new Truck(numberOfPassengers);

        if (type==SEDAN)    return new Sedan(numberOfPassengers);

        if (type==CABRIOLET) return new Cabriolet(numberOfPassengers);

        return null;
    }

   //11..1
    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0)
           throw new Exception();
        fuel += numberOfLiters;
    }

    //11..2
    public boolean isSummer(Date date, Date summerStart, Date summerEnd){

        return date.after(summerStart) && date.before(summerEnd);
    }

    //11..3
    public double getWinterConsumption(int length){
        double consumption;
        consumption = length* winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    //11..4
    public double getSummerConsumption(int length){
        double consumption;
        consumption = length * summerFuelConsumption;
        return consumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
       /*11..5
         double consumption;
         if (date.before(SummerStart) || date.after(SummerEnd)) {
            consumption = length * winterFuelConsumption + winterWarmingUp;
         } else {
             consumption = length * summerFuelConsumption;
         }
       */
        return isSummer(date,SummerStart,SummerEnd) ?
                getSummerConsumption(length) : getWinterConsumption(length);
    }

   //12..1
    private boolean canPassengersBeTransferred(){
        return isDriverAvailable() && fuel>0;
    }

   //12..2
    public int getNumberOfPassengersCanBeTransferred() {
       /* if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;
         */
        if (canPassengersBeTransferred()) return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
    /*    if (numberOfPassengers > 0) {
            fastenPassengersBelts();
            fastenDriverBelt();
        } else {
            fastenDriverBelt();
        }
     */
       fastenDriverBelt();
       if (numberOfPassengers>0) fastenPassengersBelts();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

   //12..7
    public abstract int getMaxSpeed();
   /*12..4
        if (type == TRUCK)
            return MAX_TRUCK_SPEED;
        if (type == SEDAN)
            return MAX_SEDAN_SPEED;
        return MAX_CABRIOLET_SPEED;

    */



}