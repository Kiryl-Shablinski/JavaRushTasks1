package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
      ArrayList<String> [] arraysList = new ArrayList[2];
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("hello Amigo");
        arrayList.add("привет Кирилл");

        for (int i=0;i<arraysList.length;i++){
            arraysList[i]=arrayList;

        }
        return arraysList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}