package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) return new String();
        String text = excutor(reader);
        String resText = "";
        int c = 0;
        for (int i = 0; i < text.length(); i++){
              c = (text.charAt(i) + key);
              resText += (char) c;

        }
        return resText;
    }

    public static String excutor(StringReader reader) throws IOException {
       String line;
       StringBuilder stb = new StringBuilder();
       BufferedReader bufferedReader = new BufferedReader(reader);
       while((line = bufferedReader.readLine())!= null){
           stb.append(line);
       }
        return stb.toString();
    }

}
