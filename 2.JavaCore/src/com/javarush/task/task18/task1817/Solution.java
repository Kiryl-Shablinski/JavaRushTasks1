package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Solution {
    private static int countSimbol;
    private static int countSpace;

    public static void main(String[] args) throws Exception{

        FileInputStream fInt = new FileInputStream(args[0]);
        BufferedInputStream bufferInt = new BufferedInputStream(fInt);

        while (bufferInt.available()>0){
            int bytes= bufferInt.read();
            countSimbol++;
            equalsChar(bytes);
        }

        double c = countSpace*1.0/countSimbol*100;

        System.out.printf("%.2f",c);
        bufferInt.close();
        fInt.close();

    }

    public static void equalsChar(int bytes){

        if (bytes==' ') countSpace++;

    }



}
