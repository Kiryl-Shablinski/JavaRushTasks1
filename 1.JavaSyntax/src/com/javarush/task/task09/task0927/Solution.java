package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
        //printCatMap(map);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat> map=new HashMap<>();
        map.put("Barsik",new Cat("Barsik"));
        map.put("Ryzyk",new Cat("Barsik"));
        map.put("pushok",new Cat("pushok"));
        map.put("majsik",new Cat("majsik"));
        map.put("labus",new Cat("labus"));
        map.put("brabus",new Cat("brabus"));
        map.put("petrovich",new Cat("petrovich"));
        map.put("loshara",new Cat("loshara"));
        map.put("kralja",new Cat("kralja"));
        map.put("bajun",new Cat("bajun"));



        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> setCat=new HashSet<>(map.values());
        return setCat;

    }
   /* public static void printCatMap(Map<String,Cat> map){
        for (Map.Entry<String,Cat> mapCat:map.entrySet()){
            System.out.println(mapCat.getKey()+"-"+mapCat.getValue());
        }
    }*/

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
