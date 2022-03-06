package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/



import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {


    public static void main(String[] args) throws Exception{

        TreeMap<Integer, Integer> map = new TreeMap<>();

       FileReader fRead = new FileReader(args[0]);

        while (fRead.ready()){

            addSimbol(map, fRead.read());
        }
        printSimbol(map);

        fRead.close();
    }

    public static void addSimbol (TreeMap<Integer, Integer> map, int read){

           map.merge(read,1,Integer::sum);
    }

    public static void printSimbol (TreeMap<Integer, Integer> map){

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){

            int simbol = pair.getKey();

            System.out.println((char) simbol + " " + pair.getValue());
        }
    }
}
