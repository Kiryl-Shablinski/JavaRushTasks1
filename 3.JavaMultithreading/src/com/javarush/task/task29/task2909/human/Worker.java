package com.javarush.task.task29.task2909.human;

public class Worker extends Human{
   //5..6
   // private Human human;
    private double salary;
    /* 9..3 public*/
    private String company;

    public Worker(String name, int age) {
       super(name, age);
    }

    public void live() {

    }

    public double getSalary() {
        return salary;
    }

    //5...7
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //9..3
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}