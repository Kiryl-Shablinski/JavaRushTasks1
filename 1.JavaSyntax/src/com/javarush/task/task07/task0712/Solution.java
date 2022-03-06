package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> arrayList=new ArrayList<>();
       ArrayList<String> min=new ArrayList<>();
       ArrayList<String>max=new ArrayList<>();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        int minindex=0;
        int maxindex=0;


        for (int i=0; i<10;i++){
            String line=bufferedReader.readLine();
            arrayList.add(line);
        }

        int x=arrayList.get(0).length();
        int y=arrayList.get(0).length();

        for (int i=0; i<arrayList.size();i++) {
            if (arrayList.get(i).length() < x){
                x = arrayList.get(i).length();
                 minindex = i;
            }
        }

        for (int i=0; i<arrayList.size();i++){
            if (arrayList.get(i).length()>y) {
                y = arrayList.get(i).length();
                maxindex = i;
            }
        }

        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).length()==x) {
                String s=arrayList.get(i);
                min.add(s);
            }
            if (arrayList.get(i).length()==y){
                String s=arrayList.get(i);
                max.add(s);
            }
        }

        if (minindex<maxindex) {
            System.out.println(min.get(0));
        }
        else System.out.println(max.get(0));

    }
}
