package com.javarush.task.task36.task3605;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Использование TreeSet
*/

public class Solution {


    public static void main(String[] args) throws IOException {
    TreeSet<Character> set = new TreeSet<>();
    byte[] buffer = Files.readAllBytes(Paths.get(args[0]));
 //dvhdiog7954tehio09tepgu09548-0ihg0[
        for (byte tmp : buffer){
         if (tmp >= 'a' && tmp <= 'z' || tmp >= 'A' && tmp <= 'Z'){
           char symbol = (char) tmp;
            set.add(Character.toLowerCase(symbol));
            }
        }
        int coutPrint = 0;
        for (Character text : set){
            if (coutPrint >= 5) break;
            System.out.print(text);
            coutPrint++;
        }

    }



}
