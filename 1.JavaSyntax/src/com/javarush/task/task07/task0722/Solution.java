package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrayList=new ArrayList<>();

        //напишите тут ваш код

        while (true){
            String line=reader.readLine();

            if (line.equals("end"))break;
            else{
                arrayList.add(line);
            }

        }
        for (int i=0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}