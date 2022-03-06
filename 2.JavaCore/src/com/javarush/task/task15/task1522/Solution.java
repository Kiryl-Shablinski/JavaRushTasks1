package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static{
        try {
            readKeyFromConsoleAndInitPlanet();
            readKeyFromConsoleAndInitPlanet();
            readKeyFromConsoleAndInitPlanet();
            readKeyFromConsoleAndInitPlanet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws Exception{
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String text=bufferedReader.readLine();
        if (text.equals(Planet.EARTH)){
            thePlanet=Earth.getInstance();
          // System.out.println(thePlanet);

        }else if (text.equals(Planet.MOON)){
            thePlanet=Moon.getInstance();
          // System.out.println(thePlanet);

        }else if (text.equals(Planet.SUN)){
            thePlanet=Sun.getInstance();
          //  System.out.println(thePlanet);

        } else{
            thePlanet=null;
           // System.out.println(thePlanet);
        }
    }
}
