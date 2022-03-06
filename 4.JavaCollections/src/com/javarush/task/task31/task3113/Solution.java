package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
   static AtomicInteger  countDirectory = new AtomicInteger(-1);
   static AtomicInteger countFiles = new AtomicInteger(0);
   static AtomicLong countBytes = new AtomicLong(0);

    public static void main(String[] args) throws IOException {

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       String pathText = bufferedReader.readLine();
       bufferedReader.close();
     //C:\Users\kirya\Documents\Java Core
       Path path = Paths.get(pathText);
       if (!Files.isDirectory(path)) {
           System.out.println(path.toAbsolutePath() + " - не папка");
           return;
       }
       Files.walkFileTree(path,new SimpleFileVisitor<Path>(){

           @Override
           public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
              countDirectory.addAndGet(1);
             return FileVisitResult.CONTINUE;
           }

           @Override
           public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                   countFiles.addAndGet(1);
                    countBytes.addAndGet(Files.size(file));
             return FileVisitResult.CONTINUE;
           }
       });
            System.out.println("Всего папок - " + countDirectory);
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + countBytes);




    }
}
