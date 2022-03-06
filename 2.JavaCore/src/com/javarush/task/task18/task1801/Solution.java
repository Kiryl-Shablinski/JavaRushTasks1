package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));//C:\\Users\\kirya\\Программирование\\firstFileName.txt
       FileInputStream fileInputStream=new FileInputStream(bufferedReader.readLine());
       int  max=0;
       while ((fileInputStream.available()>0)){
        int read=fileInputStream.read();
      max = Math.max(max,read);
       }
        System.out.println(max);
       fileInputStream.close();
       bufferedReader.close();

    }

}
