package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
       //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Перевертыши\\входной файл.txt

        while (fIn.ready()){
            String text = fIn.readLine();
            StringBuilder builder =new StringBuilder(text);

            System.out.println(builder.reverse());
        }
        fIn.close();

    }
}
