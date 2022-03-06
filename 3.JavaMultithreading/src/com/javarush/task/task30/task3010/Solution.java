package com.javarush.task.task30.task3010;

import java.math.BigInteger;


/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
     String result = "incorrect";

         for (int i = 2; i <= 36; i++) {
             try {
                 BigInteger big = new BigInteger(args[0], i);
                 result = String.valueOf(i);
                 break;

             } catch (Exception o) {

             }
         }
        System.out.println(result);
    }
}