package com.javarush.task.task29.task2909.user;

public class User {
    private String name;
    private String surname;
    private int age;
   //14..1
    private boolean man;

  /*14..2
    private String country;
    private String city;
    private House house;

   */
    //14..3
    private Address address;

    private Work work;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

  //14..5
    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }





    public String getAddress() {
     //14..5   return country + " " + city + " " + house.house;
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

   //13..1
    public void printInfo(){
        System.out.println("Имя: " + getName());
        System.out.println("Фамилия: " + getSurname());
    }
    //13..4

    public void printAdditionalInfo() {
        if (age<16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getBoss(){
         return work.getBoss();
    }
}