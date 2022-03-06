package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] number=new int[20];
        int maximum;
        int minimum;

        //напишите тут ваш код
        for (int i=0; i<number.length;i++){
            number[i]=Integer.parseInt(reader.readLine());
        }
        maximum=number[0];
        minimum=number[0];
        for (int i=0; i<number.length;i++){
            if (number[i]>=maximum) maximum=number[i];
            if (number[i]<=minimum) minimum=number[i];
        }


        System.out.print(maximum + " " + minimum);
    }
}
