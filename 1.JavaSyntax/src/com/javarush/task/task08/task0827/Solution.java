package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args)  throws ParseException{
        System.out.println(isDateOdd("FEBRUARY 1 2013"));
       // SimpleDateFormat dateFormat=new SimpleDateFormat("MMM d.dd G 'at' HH:mm:ss z");
        //System.out.println(dateFormat.format(new Date()));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMM d y", Locale.ENGLISH);
        Date date1=dateFormat.parse(date);
        SimpleDateFormat dateFormat1=new SimpleDateFormat("D");

       int day=Integer.parseInt(dateFormat1.format(date1));
       if (day%2==0) return false;
       else return true;

    }
}
