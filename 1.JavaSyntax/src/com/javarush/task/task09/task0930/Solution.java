package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import  java.lang.String;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<String> stringSort=new ArrayList<>();
        ArrayList<Integer> intSort=new ArrayList<>();

        for (int i=0; i<array.length;i++){
            if (isNumber(array[i])){

                Integer tmp=Integer.parseInt(array[i]);
                intSort.add(tmp);
            }
            else {
                stringSort.add(array[i]);
            }
        }
        //сортировка списка чисел
        sortInt(intSort);

        //сортировка списка строк
        sortString(stringSort);

        //объединение списков
       for (int i=0;i<intSort.size();i++){

           stringSort.add(intSort.get(i).toString());
       }

       //преобразование списка в массив
      stringSort.toArray(array);



    }
    public static ArrayList<Integer> sortInt(ArrayList<Integer> intSort){
        for (int i=intSort.size()-1;i>=1;i--){
            for (int j=0;j<i;j++){
                if (intSort.get(j)<intSort.get(j+1)){
                    int tmp=intSort.get(j);
                    intSort.set(j,intSort.get(j+1));
                    intSort.set(j+1,tmp);
                }
            }
        }
        return intSort;
    }
    public static ArrayList<String> sortString(ArrayList<String> list){
        for (int i=list.size()-1;i>=1;i--){
            for (int j=0;j<i;j++){
                if (isGreaterThan(list.get(j),list.get(j+1))){
                    String tmp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);

                }
            }
        }
        return list;

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
