package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-d");
        SimpleDateFormat dateFormat1=new SimpleDateFormat("MMM d, YYYY",Locale.ENGLISH);

        Date date=dateFormat.parse(bufferedReader.readLine());
        System.out.println(dateFormat1.format(date).toUpperCase(Locale.ENGLISH));
    }
}
