package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list=new ArrayList<>();
        String a="мама";
        String b= "мыла";
        String c="раму";
        String d="именно";
        list.add(a);
        list.add(b);
        list.add(c);

        for (int i=1; i<=list.size(); ){
          list.add(i,d);
          i=i+2;
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
