package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader fIn = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();

        while (fIn.ready()){
            String[] tmp = fIn.readLine().split(" ");

            if (!map.containsKey(tmp[0])){
                map.put(tmp[0], Double.parseDouble(tmp[1]));

            }else {

                for (Map.Entry<String, Double> pair : map.entrySet()) {

                    if (pair.getKey().equals(tmp[0])) {
                        double value = pair.getValue() + Double.parseDouble(tmp[1]);
                        pair.setValue(value);
                    }
                }
            }
        }
        fIn.close();
        for (Map.Entry<String, Double> pair: map.entrySet()) {

            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
