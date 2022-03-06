package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        int[] number=new int[15];
        int even=0;
        int uneven=0;

        for (int i=0;i<number.length;i++){
            number[i]=Integer.parseInt(bufferedReader.readLine());

            if(i%2==0) even+= number[i];
            else uneven+=number[i];
        }
        if (even>uneven) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
