package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIn = new FileInputStream(bufferedReader.readLine());//C:\\Users\\kirya\\Программирование\\firstFileName.txt
        ArrayList<Integer> arrayList = new ArrayList<>();

        addList(arrayList, fIn);
        Collections.sort(arrayList);
        equalCount(arrayList);
        printList(arrayList);

        fIn.close();
        bufferedReader.close();



    }

    public static ArrayList<Integer> addList(ArrayList<Integer> list, FileInputStream fileInputStream) throws Exception {
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }

        return list;
    }

    public static void equalCount(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);
            if (a == b) {
                list.remove(i + 1);
                i--;

            }
        }
    }

    public static void printList( ArrayList<Integer> list){
        for (Integer text: list){
            System.out.print(text + " ");
        }
    }
}
