package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        BufferedReader fIn = new BufferedReader(new FileReader(args[0]));
        while (fIn.ready()){
            String line =fIn.readLine();

            String name = line.substring(0,findIndex(line)-1);
            String date= line.substring(findIndex(line));
            Date brighDate=null;
            try {
                brighDate = new SimpleDateFormat("d M yyyy").parse(date);

            }catch (ParseException o){
                o.getMessage();
            }

            PEOPLE.add(new Person(name, brighDate));
            //System.out.println(name);
            //System.out.println(date);
        }
        fIn.close();


    }

    public static int findIndex(String text){
        char[] tmp = text.toCharArray();
        int beginIndex=0;

        for (int i=0; i<tmp.length; i++){
            if (Character.isDigit(tmp[i])){
                beginIndex = i;
                break;
            }
        }
        return beginIndex;
    }
}
