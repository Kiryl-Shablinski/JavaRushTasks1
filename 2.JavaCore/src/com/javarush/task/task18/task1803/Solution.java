package com.javarush.task.task18.task1803;




import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {

    static int  max;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIn = new FileInputStream(bufferedReader.readLine());//C:\\Users\\kirya\\Программирование\\firstFileName.txt

        byte[] bytes = new byte[256];
        addByte(bytes, fIn);

       max= maxByteCount(bytes, max);
        bytePrint(bytes,max);

        fIn.close();
        bufferedReader.close();
    }

        public static byte[] addByte (byte[] bytes, FileInputStream fIn) throws Exception{

            while (fIn.available() > 0) {
                bytes[fIn.read()] += 1;
            }

            return bytes;

        }


        public static int maxByteCount(byte[] bytes, int max){

                for (int i=0; i<bytes.length;i++){
                    max= Math.max(max,bytes[i]);
                }
           return max;
        }

    public static void bytePrint (byte[] bytes, int max){

        for (int i=0; i<bytes.length;i++){
            if (bytes[i]==max){
                System.out.print(i+ " ");
            }
        }

    }

}