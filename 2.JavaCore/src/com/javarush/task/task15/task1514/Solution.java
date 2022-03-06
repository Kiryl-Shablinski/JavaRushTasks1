package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(5.0,"vhod");
        labels.put(9.3,"Podjem");
        labels.put(7.7,"rabota");
        labels.put(8.3,"perekus");
        labels.put(11.3,"obed");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
