package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код

       for (String word: string.trim().split("\\s+")){

            
           String s=word.substring(0,1);
                   System.out.print(s.toUpperCase()+word.substring(1).concat(" "));




       }

    }
}
