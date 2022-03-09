package com.javarush.task.task33.task3310.tests;


import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage (Shortener shortener){

        String  text1 = Helper.generateRandomString();
        String text2 = Helper.generateRandomString();
        String text3 = text1;

        String[] texts = new String[] {text1, text2, text3};

        Long  id1 = shortener.getId(text1);
        Long id2 = shortener.getId(text2);
        Long id3 = shortener.getId(text3);

        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id3, id2);
        Assert.assertEquals(id1, id3);

        String idText1 = shortener.getString(id1);
        String idText2 = shortener.getString(id2);
        String idText3 = shortener.getString(id3);

        String[] idTexts = new String[]{idText1, idText2, idText3};
        Assert.assertEquals(texts, idTexts);
    }

    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

}
