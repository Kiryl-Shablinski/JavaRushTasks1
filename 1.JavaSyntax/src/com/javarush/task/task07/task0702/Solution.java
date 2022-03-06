package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String[] line=new String[10];
        for (int i=0; i<(line.length-2);i++){
            line[i]=bufferedReader.readLine();
        }
        for (int i=0; i<line.length;i++){
           System.out.println(line[9-i]);
        }
    }
}