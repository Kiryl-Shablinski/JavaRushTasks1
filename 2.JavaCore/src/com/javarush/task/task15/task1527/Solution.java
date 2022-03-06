package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String url = bufferedReader.readLine();
        bufferedReader.close();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayKey = new ArrayList<>();
        ArrayList<String> arrayValue = new ArrayList<>();


        // http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
        //http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
        int index = url.indexOf("?");
        url = url.substring(index + 1);


        for (String string : url.split("&")) {
            arrayList.add(string);
        }


        for (int i = 0; i < arrayList.size(); i++) {

            index = arrayList.get(i).indexOf("=");
            if (index == -1) {
                arrayKey.add(arrayList.get(i));
                arrayValue.add(arrayList.get(i));
            } else {
                arrayKey.add(arrayList.get(i).substring(0, index));
                arrayValue.add(arrayList.get(i).substring(index + 1));
            }
        }
        for (String text:arrayKey) {
            System.out.print(text + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayKey.size(); i++) {
            try {


                if (arrayKey.get(i).equals("obj")) {
                    double value = Double.parseDouble(arrayValue.get(i));
                    alert(value);
                }


            } catch (NumberFormatException o) {
                alert(arrayValue.get(i));

            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
