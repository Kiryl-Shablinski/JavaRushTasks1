package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        TreeSet<String> set = new TreeSet<>();
        while (!(fileName = bufferedReader.readLine()).equals("end")){
           set.add(fileName);
        }
        bufferedReader.close();
        writer(set);
    }

    public static void writer(TreeSet<String> list)throws IOException{
        String  patch = list.first().replaceAll("\\.part\\d+$", "");
       FileOutputStream fOut = new FileOutputStream(patch,true);



       for (String text : list){
           FileInputStream fIn = new FileInputStream(text);
           byte[] buffer = new byte[fIn.available()];
           fIn.read(buffer);
           fOut.write(buffer);
           fIn.close();

       }
       fOut.close();
    }
}
