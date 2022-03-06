package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fOut = new FileOutputStream(bufferedReader.readLine());
        bufferedReader.close();

        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\вывод в консоль и файл\\вывод.txt

        PrintStream consol = System.out;

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(buffer);
        System.setOut(stream);

        testString.printSomething();

         System.setOut(consol);

        System.out.println(buffer.toString());
         fOut.write(buffer.toByteArray());
         fOut.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

