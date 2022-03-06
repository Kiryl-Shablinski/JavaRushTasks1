package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;

   public Horse(){}

    public Horse(String name, double speed, double distance) {
        setName(name);
        setSpeed(speed);
        setDistance(distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
       distance+=speed*Math.random();

    }

    public void print(){
       StringBuilder stb =new StringBuilder();
       int dist= (int) distance;
       for (int i=0; i<dist; i++){
           stb.append(".");
       }
        stb.append(name);
        System.out.println(stb);
    }

    @Override
    public String toString() {
        return getName() + " Speed: "+ getSpeed() + " Distance: "+ getDistance();
    }
}
