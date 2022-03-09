package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

  public  long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
      long startTime = new Date().getTime();
        for (String text : strings){
            ids.add(shortener.getId(text));
        }

        long endTime  = new Date().getTime();

      return endTime - startTime;
  }

    public  long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long startTime = new Date().getTime();
        for (Long id : ids){
            strings.add(shortener.getString(id));
        }

        long endTime  = new Date().getTime();

        return endTime - startTime;
    }

    @Test
    public void testHashMapStorage(){
      Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
      Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

      Set<String> origStrings = new HashSet<>();
      for (int i = 0; i < 10000; i++){
          origStrings.add(Helper.generateRandomString());
      }

      Set<Long> ids1 = new HashSet<>();
      Set<Long> ids2 = new HashSet<>();

      long timeWorkHashMapId = getTimeToGetIds(shortener1,origStrings, ids1);
      long timeWorkHashBiMapId = getTimeToGetIds(shortener2,origStrings, ids2);

        Assert.assertTrue(timeWorkHashMapId > timeWorkHashBiMapId);

        long timeWorkHashMapValue = getTimeToGetStrings(shortener1, ids1, new HashSet<>());
        long timeWorkHashBiMapValue = getTimeToGetStrings(shortener2,ids2, new HashSet<>());

        Assert.assertEquals(timeWorkHashMapValue, timeWorkHashBiMapValue, 30);

    }
}
