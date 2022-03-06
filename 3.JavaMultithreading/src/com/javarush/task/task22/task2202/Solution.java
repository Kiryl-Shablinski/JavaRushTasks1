package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush-лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {

       if (string==null) throw new TooShortStringException();

        int start = string.indexOf(" ");
        int count=0;
        int finish=0;

           while (count < 5) {
               finish = string.indexOf(" ", finish + 1);
               if (finish == -1) break;
               count++;
           }

           if (count==4){
               return string.substring(start+1);
           }else if (count<4) {
               throw new TooShortStringException();
           }
        return string.substring(start+1,finish);
    }

    public static class TooShortStringException extends RuntimeException{


    }
}
