package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string)  throws TooShortStringException{
       if (string==null) throw new TooShortStringException();
        int start =string.indexOf("\t");
        int finish = string.indexOf("\t",start+1);
        if (finish==-1) throw new TooShortStringException();

        return string.substring(start+1,finish);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
