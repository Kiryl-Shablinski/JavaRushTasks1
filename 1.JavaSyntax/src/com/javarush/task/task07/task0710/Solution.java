package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> arrayList=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));


        for (int i=0; i<10; i++){
            String s=bufferedReader.readLine();
            arrayList.add(arrayList.size()-i,s);
        }

        for (int i=0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

    }
}
