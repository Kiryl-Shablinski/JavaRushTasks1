package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;


import java.io.FileInputStream;
import java.io.FileReader;


public class Solution {
    private static int count;
    public static void main(String[] args)  throws Exception {

        FileInputStream fInt = new FileInputStream(args[0]);
       BufferedInputStream bufferInt = new BufferedInputStream(fInt);

        while (bufferInt.available()>0){
           int bytes= bufferInt.read();

            if (equalsChar(bytes)){
                count++;
            }

        }

        System.out.println(count);
        bufferInt.close();
        fInt.close();

    }

    public static boolean equalsChar(int bytes){

        if (bytes >= 'a' && bytes <= 'z' || bytes >= 'A' && bytes <= 'Z')
            return true;

        return false;
    }
}
