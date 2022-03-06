package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String text=bufferedReader.readLine();
            if (text.equals("exit")) break;
          convertation(text);
        }
        bufferedReader.close();

    }

    public static void convertation(String text){
        try{
            int value = Integer.parseInt(text);
            if (value > 0 && value < 128) {
                short value1=(short)value;
                print(value1);
            }else
            print(value);


        }catch (NumberFormatException o) {

            try {
                double value=Double.parseDouble(text);
                print(value);


            } catch (NumberFormatException s) {
                print(text);

            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

