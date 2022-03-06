package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0,"ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Замена чисел\\вход.txt
        bufferedReader.close();


        while (fIn.ready()){
            String line = fIn.readLine();
            String[] word = line.split(" ");
            for (int i=0; i<word.length; i++){
                try {
                    int number = Integer.parseInt(word[i]);

                    if (map.containsKey(number)) {
                        word[i]=map.get(number);

                    }
                }catch (NumberFormatException o){
                    continue;
                }
            }


            for (String string : word){
                System.out.print(string + " ");

            }
            System.out.println();



        }

        fIn.close();


    }
}
