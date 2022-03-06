package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile raf = new RandomAccessFile(args[0],"rw")){
           int number = Integer.parseInt(args[1]);
           String text = (args[2]);
           byte[] buffer = new byte[text.getBytes(StandardCharsets.UTF_8).length];
            raf.seek(number);
            raf.read(buffer,0, buffer.length);
            String textRead = new String(buffer);
            if (textRead.equals(text)){
                raf.seek(raf.length());
                raf.write("true".getBytes(StandardCharsets.UTF_8));
            }else{
                raf.seek(raf.length());
                raf.write(text.getBytes(StandardCharsets.UTF_8),0, buffer.length);
                raf.write("false".getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
