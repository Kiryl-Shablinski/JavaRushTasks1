package com.javarush.task.task35.task3505;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>> Map convert(List <V> list) {
        Map result = new HashMap();
        for (V addObject: list) {
            result.put(addObject.getKey(), addObject);
        }
        return result;
    }
}
