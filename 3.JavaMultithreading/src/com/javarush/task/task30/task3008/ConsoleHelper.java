package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String message = null;
        boolean repeatInput = true;

       while (repeatInput) {
           try {
               message = bufferedReader.readLine();
               repeatInput = false;

           } catch (IOException o) {
               System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
           }
       }
        return message;
    }

    public static int readInt(){
        int message =0;
        boolean repeatInput = true;

        while(repeatInput){
            try{
              message = Integer.parseInt(readString());
                repeatInput = false;

            }catch (NumberFormatException o){
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return message;
    }
}
