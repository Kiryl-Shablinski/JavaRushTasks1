package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код

        Map<String,String>map=new HashMap<>();
            map.put("Shablinski","Kiryl");
            map.put("Shablinskaya","Iryna");
            map.put("Shablinskaya","Mariya");
            map.put("Shablinski","Dmitryj");
            map.put("Kuchinskaya","Alena");
            map.put("Novik","Nataliya");
            map.put("Severtoka","Dmitryj");
            map.put("Butko","Alena");
            map.put("Molite","Nataliya");
            map.put("Leshkevich","Andrey");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
