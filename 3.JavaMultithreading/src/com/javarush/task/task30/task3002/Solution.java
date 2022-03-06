package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix = 0;

       if (s.startsWith("0x")){
         radix = Integer.parseInt(s.substring(2),16);
       }else  if (s.startsWith("0b")){
          radix = Integer.parseInt(s.substring(2),2);
       }else if (s.startsWith("0")){
          radix = Integer.parseInt(s,8);
       }else{
           radix = Integer.parseInt(s);
       }
       return String.valueOf(radix);
    }
}
