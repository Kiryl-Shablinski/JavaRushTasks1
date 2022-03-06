package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5;i++){
            String s=bufferedReader.readLine();
            list.add(s);
        }

        for (int i=0; i<13;i++){
            String s=list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,s);
        }

        for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
