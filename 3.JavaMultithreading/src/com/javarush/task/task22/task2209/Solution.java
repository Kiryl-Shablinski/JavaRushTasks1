package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        //...
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
      bufferedReader.close();
          //C:\\Users\\kirya\\Documents\\Java Multithreading\\level 2\\цепочки слов\\FileInput.txt
          ArrayList<String> list = new ArrayList<>();
           while(fIn.ready()){
             list.addAll(Arrays.asList(fIn.readLine().split("\\s+")));
           }
           fIn.close();

          StringBuilder  result = getLine(convertArray(list));
          System.out.println(result.toString());

    }

    public static String [] convertArray( List<String> list){
      String [] word = new String[list.size()];
      for(int i=0; i<list.size();i++){
          word[i]= list.get(i);
      }
       return word;
    }

    public static StringBuilder getLine(String... words) {
      int countWord=0;
       if (words.length==0) return new StringBuilder();


       StringBuilder stb = new StringBuilder(words[0]);
       List<String> list = addedList(words);

        while (!list.isEmpty()) {
               String tmp =list.get(0);

               if (tmp.substring(0,1).equalsIgnoreCase(stb.substring(stb.length()-1))){
                   stb.append(" ").append(tmp);
                   list.remove(0);
                 //  System.out.println(list);
                 //  System.out.println(stb.toString());

               }else if (tmp.substring(tmp.length()-1).equalsIgnoreCase(stb.substring(0,1))){
                   stb.insert(0," ").insert(0,tmp);
                   list.remove(0);
                //   System.out.println(list);
                //   System.out.println(stb.toString());

               }else {
                  if (countWord>list.size()) {
                      stb.append(" ").append(tmp);
                      break;
                  }
                   list.add(tmp);
                   list.remove(0);
                   countWord++;

                 //  System.out.println(list);
                 //  System.out.println(stb.toString());
               }

        }
        return stb;
    }

    public static List<String> addedList(String... words){
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));
        list.remove(0);

        return  list;
    }
}
