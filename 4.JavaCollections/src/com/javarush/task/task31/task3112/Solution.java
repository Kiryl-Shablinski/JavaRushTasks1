package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
       URL url = new URL(urlString);
       InputStream in = url.openStream();
       Path tmpFile = Files.createTempFile(url.getFile(),".tmp");
       Files.copy(in,tmpFile);
       Path resultatFile = downloadDirectory.resolve(Paths.get(url.getFile()).getFileName().toString());
        Files.move(tmpFile,resultatFile);

        return resultatFile;
    }
}
