package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        int deep=Thread.currentThread().getStackTrace().length;
        //напишите тут ваш код
        System.out.println(deep );
        return deep;
    }
}

