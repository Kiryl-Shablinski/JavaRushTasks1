package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
      File resultFile = new File(resultFileName);
        Set<String> fileParts = new TreeSet<>(Arrays.asList(args).subList(1, args.length));
        Vector<InputStream> zipFile = new Vector<>();
        try {
            for (String file : fileParts) {
                zipFile.addElement(Files.newInputStream(Paths.get(file)));
            }

            try(ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream(zipFile.elements()));
            FileOutputStream fileOut = new FileOutputStream(resultFile)){

                ZipEntry entry;

                while((entry = zipIn.getNextEntry()) != null){
                    byte[] buffer = new byte[8 * 1024];
                    int read = 0;
                    while ((read = zipIn.read(buffer)) > 0){
                        fileOut.write(buffer,0, read);
                    }
                }

            }
        }catch (IOException o){
            o.printStackTrace();
        }



    }


}
