package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings=new ArrayList<>();
        ArrayList<String> min=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

       for (int i=0; i<5;i++){
           String s=bufferedReader.readLine();
           strings.add(s);
       }
       int s =strings.get(0).length();

       for (int i=0; i<strings.size();i++){
           if (strings.get(i).length()<s) {
                s = strings.get(i).length();
           }
          
       }
       
       for (int i=0; i<strings.size(); i++){
           if (strings.get(i).length()==s){
               String line=strings.get(i);
               min.add(line);
           }
       }

       for (int i=0; i<min.size();i++){
           System.out.println(min.get(i));
       }

    }

}
