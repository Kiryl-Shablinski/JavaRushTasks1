package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public  class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream amigo;

    public QuestionFileOutputStream(AmigoOutputStream amigo){
        this.amigo=amigo;
    }


    public void flush() throws IOException {
    amigo.flush();
    }


    public void write(int b) throws IOException {
        amigo.write(b);

    }


    public void write(byte[] b) throws IOException {
        amigo.write(b);

    }


    public void write(byte[] b, int off, int len) throws IOException {
        amigo.write(b,off,len);

    }

    public void close() throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (bufferedReader.readLine().equals("Д")){
          amigo.close();
        }


    }
}

