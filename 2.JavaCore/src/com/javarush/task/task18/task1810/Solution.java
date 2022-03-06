package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import com.sun.org.apache.bcel.internal.generic.IFLE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, Exception {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fIn=new FileInputStream(bufferedReader.readLine());

            readFile(fIn,bufferedReader);
            fIn.close();
            bufferedReader.close();
        throw new DownloadException();




    }

    public static void readFile(FileInputStream fIn, BufferedReader buffer) throws Exception{
        while (fIn.available()>=1000){
            fIn= new FileInputStream(buffer.readLine());
        }


    }

    public static class DownloadException extends Exception {

    }
}
