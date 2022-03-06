package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol= System.out;

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream stream =  new PrintStream(buffer);
        System.setOut(stream);
        testString.printSomething();
       String text ="JavaRush - курсы Java онлайн";
       System.setOut(consol);
       String[] line = buffer.toString().split("\\n");
       for (int i=0; i<line.length;i++){
           if (i%2!=0) {
               System.out.println(line[i]);
               System.out.println(text);
           }else{
               System.out.println(line[i]);
           }
       }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
