package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int[] number=new int[20];
        int[] number1=new int[10];
        int[] number2=new int[10];
        for (int i=0; i<number.length;i++) {

            number[i] = Integer.parseInt(bufferedReader.readLine());

        if(i<(number.length/2)) number1[i]=number[i];
            else number2[i-(number.length/2)]=number[i];

        }
        for (int i=0; i<number2.length;i++){
            System.out.println(number2[i]);
        }

    }
}
