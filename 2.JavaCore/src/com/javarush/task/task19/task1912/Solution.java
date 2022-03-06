package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol =System.out;

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream stream =new PrintStream(buffer);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(consol);
        String result =buffer.toString().replaceAll("te","??");

        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
