package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String,String> map=new HashMap<>();
        map.put("shablinski","kiryl");
        map.put("shablinskaya","mariya");
        map.put("Novik","Nataliya");
        map.put("kuchynskaya","alena");
        map.put("leshkevich","kiryl");
        map.put("zhulego","viktor");
        map.put("sokolinski","kiryl");
        map.put("dovgal","nikoaj");
        map.put("bogushevich","victor");
        map.put("savenko","evgen");


        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
       int countfirstname=0;

      for (String value:map.values()){

          if(name.equals(value)) countfirstname++;
      }

      return countfirstname;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int countlastName=0;

        for (String key:map.keySet()){

            if (lastName.equals(key)) countlastName++;
        }

        return countlastName;
    }

    public static void main(String[] args) {

    }
}
