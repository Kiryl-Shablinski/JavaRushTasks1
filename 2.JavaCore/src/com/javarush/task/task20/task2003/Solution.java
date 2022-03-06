package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws  Exception{
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       String file = bufferedReader.readLine();
        bufferedReader.close();
        FileOutputStream fOut = new FileOutputStream(file);
        FileInputStream fIn = new  FileInputStream(file);

       // save(fOut);
        fOut.close();

        load(fIn);
        fIn.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
       Properties properties1 = new Properties();

        for (Map.Entry<String, String> pair : properties.entrySet()){
            properties1.setProperty(pair.getKey(), pair.getValue());
            properties1.store(outputStream,"properties");

        }

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        Properties properties1 = new Properties();
        properties1.load(buffer);
        buffer.close();

        for (String name : properties1.stringPropertyNames()){
            properties.put(name, properties1.getProperty(name));
        }

    }

    public static void main(String[] args) throws Exception{



    }
}
