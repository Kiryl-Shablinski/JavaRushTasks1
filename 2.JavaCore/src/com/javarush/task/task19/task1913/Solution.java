package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol =System.out;

        ByteArrayOutputStream buffer =new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(buffer);

        System.setOut(stream);
         testString.printSomething();
         System.setOut(consol);

         String result =buffer.toString().replaceAll("\\D","");

        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
