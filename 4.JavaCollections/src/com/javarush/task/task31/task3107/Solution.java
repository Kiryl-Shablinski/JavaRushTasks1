package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try{
            this.fileData = new ConcreteFileData(Files.isHidden(Paths.get(pathToFile)),
                    Files.isExecutable(Paths.get(pathToFile)),
                    Files.isDirectory(Paths.get(pathToFile)),
                    Files.isWritable(Paths.get(pathToFile)));

        }catch (Exception o){
            fileData = new NullFileData(o);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
