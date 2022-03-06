package com.javarush.task.task08.task0816;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Кирилл",dateFormat.parse("JULY 29 1985"));
        map.put("Ира",dateFormat.parse("JUNE 29 1990"));
        map.put("Алена",dateFormat.parse("MARCH 13 1984"));
        map.put("Мария",dateFormat.parse("JULY 18 2014"));
        map.put("Галина",dateFormat.parse("JUNE 16 1960"));
        map.put("Александр",dateFormat.parse("OCTOBER 25 1958"));
        map.put("Наталья",dateFormat.parse("SEPTEMBER 26 1975"));
        map.put("Наташка",dateFormat.parse("DECEMBER 11 1985"));
        map.put("Мелкий", dateFormat.parse("JANUARY 27 1993"));
        //напишите тут ваш код
        return  map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Date date=new Date();
        Iterator<Map.Entry<String,Date>> entryes=map.entrySet().iterator();

        while (entryes.hasNext()){

            Map.Entry<String, Date> entry=entryes.next();
            date=entry.getValue();
            int Month=date.getMonth();

            if (Month==5||Month==6||Month==7){
            entryes.remove();
            }
        }



    }

    public static void main(String[] args) {


    }
}
