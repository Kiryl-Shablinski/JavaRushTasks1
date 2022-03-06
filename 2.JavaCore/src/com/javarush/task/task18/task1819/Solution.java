package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(bufferedReader.readLine());
        File file2 =  new File(bufferedReader.readLine());

        //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\write.txt
       //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл в обратном порядке.txt

        bufferedReader.close();

        FileInputStream fIn = new FileInputStream(file1);
        BufferedInputStream bufferRead = new BufferedInputStream(fIn);

        byte[] buffer = new byte[bufferRead.available()];
        int read=0;
        boolean writer=false;

        if (bufferRead.available()>0){
             read=bufferRead.read(buffer);

        }

        fIn.close();
        bufferRead.close();

        FileOutputStream fOut = new FileOutputStream(file1,writer);
        fIn= new FileInputStream(file2);
        bufferRead = new BufferedInputStream(fIn);

        while (bufferRead.available()>0){

            int read1 = bufferRead.read();
            fOut.write(read1);
        }

        writer = true;
        fOut.write(buffer,0,read);

        fOut.close();
        fIn.close();
        bufferRead.close();


    }
}
