package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fOut1;
        FileInputStream fIn2, fIn3;

        fOut1 = new FileOutputStream(bufferedReader.readLine(),true);
        fIn2 = new FileInputStream(bufferedReader.readLine());
        fIn3 = new FileInputStream(bufferedReader.readLine());

        bufferedReader.close();

        //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\write.txt
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл для чтения.txt
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл в обратном порядке.txt

        writeByte(fOut1,fIn2);
        writeByte(fOut1,fIn3);

        fOut1.close();
        fIn2.close();
        fIn3.close();




    }

    public static void writeByte(FileOutputStream fOut, FileInputStream fIn) throws Exception{
        BufferedInputStream buffer = new BufferedInputStream(fIn);
        int i;
        while ((i=buffer.read())!=-1){
            fOut.write(i);
        }

        buffer.close();
    }
}
