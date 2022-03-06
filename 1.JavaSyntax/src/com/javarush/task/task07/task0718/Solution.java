package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 10; i++) {
            String list = bufferedReader.readLine();
            arrayList.add(list);
        }
        arrayList=Lenghtlist(arrayList);
    }
            public static ArrayList<String> Lenghtlist( ArrayList<String> arrayList) {
            int lenghtlist = arrayList.get(0).length();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).length() >= lenghtlist) lenghtlist = arrayList.get(i).length();
                else {
                    System.out.println(i);
                    break;
                }
            }
            return arrayList;
        }

}

