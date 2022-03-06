package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new FileStorageStrategy(),100);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
      Set<Long> ides = new HashSet<>();
      for (String value : strings){
         ides.add(shortener.getId(value));
      }
        return ides;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> values = new HashSet<>();

        for (Long key : keys){
            values.add(shortener.getString(key));
        }
        return values;
    }

    public static  void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
      Set<String> testString = new HashSet<>();
      for (int i = 0; i < elementsNumber; i ++){
          testString.add(Helper.generateRandomString());
      }
      Shortener shortener = new Shortener(strategy);
        long startTimeId = new Date().getTime();
        Set<Long> testIdes = getIds(shortener, testString);
        long workTimeId = new Date().getTime() - startTimeId;
        Helper.printMessage("Время получения ключей " + workTimeId);

        long startTimeString = new Date().getTime();
        Set<String> setWorkTime = getStrings(shortener, testIdes);
        long workTimeString = new Date().getTime() - startTimeString;
        Helper.printMessage("Время получения значений " + workTimeString);



        if (equalsSets(testString,setWorkTime)) {
            Helper.printMessage("Тест пройден.");
        }else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    private static <T> boolean  equalsSets(Set<T> setOne, Set<T> setTwo){

        return setOne.equals(setTwo);
    }
}
