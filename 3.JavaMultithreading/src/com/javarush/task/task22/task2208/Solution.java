package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name","Shabinski");
        map.put("country",null);
        map.put("city","Grodno");
        map.put("age",null);

        System.out.println(getQuery(map));


    }
    public static String getQuery(Map<String, String> params) {
        String textFirst ="%s = '%s'";
        String textLast =" and %s = '%s'";

        StringBuilder stb = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue()!=null){
                if (stb.length()!=0){
                    stb.append(String.format(textLast, pair.getKey(), pair.getValue()));
                }else {
                    stb.append(String.format(textFirst, pair.getKey(), pair.getValue()));
                }
            }
        }

        return stb.toString();
    }
}
