package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Самые редкие байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIn = new FileInputStream(bufferedReader.readLine());//C:\\Users\\kirya\\Программирование\\secondFileName.txt                                                                            //C:\\Users\\kirya\\Программирование\\firstFileName.txt
        byte[] bytes = new byte[256];

        addByte(bytes,fIn);
       bytePrint(bytes,minByteCount(bytes));

       fIn.close();
       bufferedReader.close();
    }

        public static byte[] addByte (byte[] bytes, FileInputStream fIn) throws Exception{

            while (fIn.available() > 0) {
                bytes[fIn.read()] += 1;
            }
            return bytes;
        }

    public static int minByteCount(byte[] bytes){
     int min=0;

       for (int n=0;n<bytes.length;n++){
           if (bytes[n]>0) {
                min=bytes[n];
               break;
           }
       }


        for (int i=0; i<bytes.length;i++){
           if (bytes[i]<min && bytes[i]>0) min=bytes[i];
        }
        return min;
    }


    public static void bytePrint (byte[] bytes, int min){

        for (int i=0; i<bytes.length;i++){
            if (bytes[i]==min && bytes[i]!=0){
                System.out.print(i+ " ");
            }
        }

    }

}
