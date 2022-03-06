package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

            ArrayList<Integer> arrayList = new ArrayList<>();
            Scanner scanner = new Scanner(fileInputStream);
            int number;
            while (scanner.hasNext()) {
                number = scanner.nextInt();

                if (number % 2 == 0) {
                    arrayList.add(number);
                }
            }
        bufferedReader.close();
        fileInputStream.close();
        scanner.close();
        Collections.sort(arrayList);
        for (Integer text : arrayList) {
            System.out.println(text);
        }




    }
}
