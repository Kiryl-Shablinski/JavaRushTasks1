package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
   private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException{
        String message = "";
        message = bufferedReader.readLine();
        return message;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Пожалуйста, выберите блюдо из списка");
        String dish = readString().toUpperCase();

        while(!dish.equalsIgnoreCase("exit")) {
            if (dishContains(dish)) {
                dishes.add(Dish.valueOf(dish));
            }else{
                writeMessage("Такого блюда нет");
            }
            dish = readString().toUpperCase();
        }

        return dishes;
    }
    public static boolean dishContains( String  name){
       boolean yesContains = true;
       try {
          Dish.valueOf(name);
       }catch (IllegalArgumentException o){
           yesContains = false;
       }
        return yesContains;
    }
}
