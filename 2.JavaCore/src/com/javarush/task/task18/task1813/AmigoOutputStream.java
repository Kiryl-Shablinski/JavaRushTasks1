package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fileOutputStream;


    public static void main(String[] args) throws FileNotFoundException {
      new AmigoOutputStream(new FileOutputStream(fileName));

    }

   public AmigoOutputStream(FileOutputStream fileOut) throws FileNotFoundException{
       super(fileName);
       this.fileOutputStream = fileOut;
   }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        String text = "JavaRush © All rights reserved.";
        byte[] buffer = text.getBytes();
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
}
