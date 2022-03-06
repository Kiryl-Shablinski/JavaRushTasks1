package com.javarush.task.task08.task0828;

import sun.applet.resources.MsgAppletViewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {


    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String month=bufferedReader.readLine();

       Map<String,String> map=new HashMap<>();

        SimpleDateFormat dateFormat=new SimpleDateFormat("MMMM",Locale.ENGLISH);
        SimpleDateFormat dateFormat1=new SimpleDateFormat("M");
            Date nameMonth=dateFormat.parse(month);
            String numberMonth=dateFormat1.format(nameMonth);
        map.put(month,numberMonth);

        for (Map.Entry<String,String> pair :map.entrySet()) {


            System.out.println(pair.getKey() + " is the " + pair.getValue() + " month");
        }

    }


}
