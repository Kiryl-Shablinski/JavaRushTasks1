package com.javarush.task.task08.task0817;

import javax.print.DocFlavor;
import java.sql.SQLTransactionRollbackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String,String> copy=new HashMap<>(map);

        for (Map.Entry<String, String>pair:copy.entrySet()){

            String value=pair.getValue();
            for (Map.Entry<String,String> pair1:copy.entrySet()){
                if (pair1.getValue().equals(pair.getValue())&&!(pair1.getKey().equals(pair.getKey()))){
                    removeItemFromMapByValue(map,value);
                }
            }

        }





    }

    public static  void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }

        }

    }

    public static void main(String[] args) {




    }
}
