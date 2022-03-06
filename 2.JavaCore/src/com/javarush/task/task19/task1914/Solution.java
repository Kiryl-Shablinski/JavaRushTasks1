package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol =System.out;

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(buffer);
        System.setOut(stream);
            testString.printSomething();
        System.setOut(consol);

        String result =buffer.toString().trim();

        System.out.print(result + " " + parsing(buffer.toString()));



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static Integer parsing (String text){
        Pattern pNum =Pattern.compile("\\d+");
        Pattern pAct = Pattern.compile("[+\\-*]");

        List<Integer> nums =new ArrayList<>();
        List<String> acts = new ArrayList<>();

        Matcher mNum =pNum.matcher(text);
        Matcher mAct = pAct.matcher(text);

        while(mNum.find()){
          //  System.out.println(mNum.group());
            nums.add(Integer.parseInt(mNum.group()));
        }

        while(mAct.find()){
          //  System.out.println(mAct.group());
            acts.add(mAct.group());
        }

       // System.out.println(nums);
       // System.out.println(acts);
        return  sum(nums,acts);
    }

    public static Integer sum(List<Integer> nums, List<String> acts){
        int a= nums.get(0);
        int b = nums.get(1);
        int c=0;

        switch (acts.get(0)) {

            case "+":  c = a+b;
            break;

            case"-" : c = a - b;
            break;

            case "*" : c = a * b;
            break;

        }
        return c;

    }
}

