package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String file=bufferedReader.readLine();
        FileInputStream fileInputStream=new FileInputStream(file);
        int i;
        while((i=fileInputStream.read())!=-1){
            System.out.print((char)i);
        }
        fileInputStream.close();
        bufferedReader.close();

    }
}