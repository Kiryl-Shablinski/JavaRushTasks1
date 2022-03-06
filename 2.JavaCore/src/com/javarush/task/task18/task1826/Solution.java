package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
     // String a = "-e";
    //  String b = "C:\\tmp\\Файл для шифровки.txt";
    //  String c =  "C:\\tmp\\шифровка.txt";

     //   String a = "-d";
     //  String b = "C:\\tmp\\шифровка.txt";
     //   String c =  "C:\\tmp\\результат.txt";



        switch (args[0]){

            case "-e": encrypt(args[1], args[2]);
            break;

            case "-d" : decrypt(args[1], args[2]);
            break;
        }

    }

    public static void encrypt (String in, String out) throws IOException {
        FileInputStream fIn = new FileInputStream(in);
        FileOutputStream fOut = new FileOutputStream(out);
        while (fIn.available()>0){
            int read = fIn.read();
            fOut.write(read+15);
        }

        fIn.close();
        fOut.close();
    }

    public static void decrypt (String in, String out) throws IOException {
        FileInputStream fIn = new FileInputStream(in);
        FileOutputStream fOut = new FileOutputStream(out);
        while (fIn.available()>0){
            int read = fIn.read();
            fOut.write(read-15);
        }
        fIn.close();
        fOut.close();
    }

}
