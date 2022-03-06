package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count=0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fr = new FileReader(bufferedReader.readLine());
        FileWriter fw =new FileWriter(bufferedReader.readLine());
        //C:\\tmp\\Файл для шифровки.txt
        //C:\\tmp\\четный байт.txt
        bufferedReader.close();

        while (fr.ready()){
            int read = fr.read();
            count++;

            if (count%2==0){
                fw.write(read);
            }
        }
        fr.close();
        fw.close();

    }
}
