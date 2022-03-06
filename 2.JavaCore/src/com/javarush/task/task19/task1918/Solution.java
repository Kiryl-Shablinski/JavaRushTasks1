package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Знакомство с тэгами\\Teg.txt


        StringBuilder lineHtml = new StringBuilder();

        while (fIn.ready()) {

            lineHtml = lineHtml.append(fIn.readLine());
        }

        fIn.close();

        Map<Integer, Integer > map = new TreeMap<>();

        String tegOpen = "<" + args[0] + ">?";
        String tegClouse = "</" + args[0] + ">";


        Pattern pattern = Pattern.compile(tegOpen);
        Matcher matcher = pattern.matcher(lineHtml);

        Pattern pattern1 = Pattern.compile(tegClouse);
        Matcher matcher1 = pattern1.matcher(lineHtml);
        int start=0;
        int end=0;
        while (matcher.find()) {

            while (matcher1.find()){
                break;
            }

            if (matcher.start()<end){
                map.put(matcher.start(),end);
               map.replace(start,end,matcher1.end());
                start= matcher.start();
                end =matcher1.end();
            }else{
                start= matcher.start();
                end =matcher1.end();
                map.put(start,end);
            }

        }

       for (Map.Entry<Integer, Integer> pair : map.entrySet()){

           System.out.println(lineHtml.substring(pair.getKey(),pair.getValue()));
       }





    }
}
