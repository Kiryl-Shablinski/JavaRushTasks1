package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;



public class Solution {
    public static void main(String[] args) throws IOException {

        int count=0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
//C:\\tmp\Считаем слово\\считаем слово.txt


       while (fileReader.ready()) {
           StringBuilder text = new StringBuilder(fileReader.readLine());
          String [] word =text.toString().split("\\W");

          for (String tmp : word){
              if (tmp.equals("world")){
                  count++;
              }
          }
       }
        System.out.println(count);
       fileReader.close();

    }

}
