package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        double d = (char) 2.50256e2d;
        char c =  'd';
        short s = (short) 2.22;
        int i = 150000;
        float f =  0.50f;
        double result = f + (i / c) - (d * s) - 500e-3;

      /*  System.out.println("d "+d);
        System.out.println("c "+Integer.toUnsignedLong(c));
        System.out.println("s "+s);
        System.out.println("i "+i);
        System.out.println("f "+f);*/
        System.out.println("result: " + result);


    }
}