package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String,Integer> map=new HashMap<>();
        map.put("shablinski",1000);
        map.put("balinski", 600);
        map.put("cokolinski",950);
        map.put("pupkin",300);
        map.put("koshkin",450);
        map.put("leshkin",510);
        map.put("matreshkin",600);
        map.put("lelik",480);
        map.put("bolik",800);
        map.put("sacik",370);
        return map;

    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Integer>> entryIterator=map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            int cash = entry.getValue();
            if (cash<500) entryIterator.remove();
        }

    }

    public static void main(String[] args) {



    }
}