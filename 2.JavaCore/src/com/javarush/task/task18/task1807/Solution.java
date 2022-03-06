package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    static int count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        //"C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\comma count.txt"

       char c =',';
      long commaLong= Integer.toUnsignedLong(c);
      int comma=(int) commaLong;

      while (fileInputStream.available()>0){
          int read = fileInputStream.read();
          countComma(read,comma);
      }
        System.out.println(count);

      fileInputStream.close();
      bufferedReader.close();
    }

    public static int countComma(int read, int comma){
        if (read==comma) {
            count++;
        }

        return count;
    }
}
