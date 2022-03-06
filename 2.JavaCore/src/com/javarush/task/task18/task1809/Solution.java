package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIn= new FileInputStream(bufferedReader.readLine());
        FileOutputStream fOut = new FileOutputStream(bufferedReader.readLine());
        /*
        C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл для чтения.txt
        C:\\Users\kirya\\Documents\\Java Core\\Level 8\\файл в обратном порядке.txt
         */

        byte[] buffer = new byte[fIn.available()];
        fIn.read(buffer);
       // System.out.println(Arrays.toString(buffer));

        for (int i=buffer.length-1; i>=0;i--){
            fOut.write(buffer[i]);
        }

        fOut.close();
        fIn.close();
        bufferedReader.close();



    }
}
