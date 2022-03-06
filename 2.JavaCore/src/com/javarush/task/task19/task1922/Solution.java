package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Нужные строки\\Входные данные.txt

        while (fIn.ready()){
            int count=0;
           String text = fIn.readLine();
            String[] line = text.split(" ");

            for (String word : line){
                for (String tmp : words){
                    if (word.equals(tmp)){
                        count++;
                    }
                }
            }
            if (count==2) {
                System.out.println(text);
            }
        }
        fIn.close();
    }
}
