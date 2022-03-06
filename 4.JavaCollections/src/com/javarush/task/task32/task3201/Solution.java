package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
         try(RandomAccessFile raf = new RandomAccessFile(args[0],"rw")){
             long lenghtFile = raf.length();
             int number = Integer.parseInt(args[1]);

            if ( number > lenghtFile){
                raf.seek(lenghtFile);
                raf.write(args[2].getBytes(StandardCharsets.UTF_8));
            }else {
                raf.seek(number);
                raf.write(args[2].getBytes(StandardCharsets.UTF_8));
            }



         }catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
