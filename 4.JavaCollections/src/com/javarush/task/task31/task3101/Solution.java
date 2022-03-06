package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Consumer;

/* 
Проход по дереву файлов
*/

public class Solution extends SimpleFileVisitor<Path> {




    public static void main(String[] args) throws IOException{
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File file = new File(resultFileAbsolutePath);
        File fileDestination = new File(file.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(file, fileDestination);
       Map<String, File> mapFile = new TreeMap<>();

        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                File tmpfile = file.toFile();

                if (tmpfile.length() > 0 && tmpfile.length() <= 50){
                   mapFile.put(tmpfile.getName(), tmpfile);                }

                return FileVisitResult.CONTINUE;
            }
        });

        try (FileOutputStream out = new FileOutputStream(fileDestination)){
              for (File fileWrite : mapFile.values()){
                  out.write(Files.readAllBytes(fileWrite.toPath()));
                  out.write("\n".getBytes());
              }
        }


    }


}
