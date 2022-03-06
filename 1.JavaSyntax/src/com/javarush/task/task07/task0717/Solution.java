package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list=new ArrayList<>();
        for (int i=0;i<10; i++){
            String s=bufferedReader.readLine();
            list.add(s);
        }

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (int i=0; i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i=1; i<=list.size(); ){
            String s=list.get(i-1);
            list.add(i,s);
            i=i+2;
        }
        return list;
    }
}
