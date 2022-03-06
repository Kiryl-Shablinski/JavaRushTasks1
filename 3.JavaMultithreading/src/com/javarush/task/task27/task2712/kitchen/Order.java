package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {


    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
       initDishes();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public int getTotalCookingTime(){
        int time = 0;

        for(Dish dish : dishes){
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty(){

        if (dishes.isEmpty()) return true;
        return false;
    }

    @Override
    public String toString() {
        if (this == null) return null;
        else return "Your orger:" + dishes + " of " + tablet.toString() +
                ", cooking time " +getTotalCookingTime() + "min";
    }
}
