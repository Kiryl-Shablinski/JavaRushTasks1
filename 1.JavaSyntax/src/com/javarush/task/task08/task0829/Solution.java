package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import  java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        List<String> list1=new ArrayList<>();

        while (true) {

            String city=reader.readLine();
            if (city.isEmpty()){
                break;
            }
            list1.add(city);

            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            list.add(family);


        }

        // Read the house number

        String city1=reader.readLine();
        for (int i=0; i<list1.size();i++) {

            if (city1.equals(list1.get(i))) {
                String familyName = list.get(i);
                System.out.println(familyName);
            }
        }
    }
}
