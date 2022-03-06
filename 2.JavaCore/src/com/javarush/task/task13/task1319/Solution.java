package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        String file=bufferedReader.readLine();

        BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(file));



        while (true){
            file=bufferedReader.readLine();
            if(file.toLowerCase().equals("exit")){
                bufferedWriter.write(file+"\n");
                break;
            }
            bufferedWriter.write(file+"\n");
        }
        bufferedWriter.close();
        bufferedReader.close();


    }
}
