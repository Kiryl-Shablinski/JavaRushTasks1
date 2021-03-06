package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sound.midi.Patch;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        T classRead = mapper.readValue(new File(fileName), clazz);

        return classRead;
    }

    public static void main(String[] args) {

    }
}
