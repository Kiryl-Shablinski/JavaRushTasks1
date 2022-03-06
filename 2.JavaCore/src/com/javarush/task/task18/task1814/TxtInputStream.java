package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.UnexpectedException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws  UnsupportedFileNameException, IOException {
        super(fileName);
        if (!txtLine(splitString(fileName))){
           super.close();
            throw new UnsupportedFileNameException();

        }else new FileInputStream(fileName);



    }

    public static String[] splitString(String text){

        return text.trim().split("\\.");
    }

    public static boolean txtLine(String[] text){

       if (text[text.length-1].equals("txt")){
           return true;
       }
        return false;
    }

    public static void main(String[] args) {

    }
}

