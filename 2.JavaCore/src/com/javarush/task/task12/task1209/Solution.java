package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {
        /*System.out.println(min(2,5));
        System.out.println(min(2.0,1.0));
        System.out.println(min(45,23));*/
    }

    //Напишите тут ваши методы
    public static int min(int a, int b){
        return a<b ? a: b;
    }

    public static long min(long a, long b){
        return a<b ? a:b;
    }
    public static double min(double a, double b){
        return a<b ? a: b;
    }
}
