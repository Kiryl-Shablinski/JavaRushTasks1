package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        writeFile(args[1],readFile(args[0]));
    }

    public static String readFile(String file){
        String text=null;
        try(BufferedInputStream fIn = new BufferedInputStream(new  FileInputStream(file))){

           byte[] buffer = new byte[fIn.available()];
          while(fIn.available()>0) {
              fIn.read(buffer);
          }
            text = new String (buffer,"Windows-1251");


        }catch (IOException o){
            o.printStackTrace();
        }
        return text;
    }

    public static void writeFile(String file, String text){

        try(BufferedOutputStream fOut = new BufferedOutputStream(new FileOutputStream(file))){
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
            fOut.write(buffer);
        }catch(IOException o){
            o.printStackTrace();
        }

    }
}
