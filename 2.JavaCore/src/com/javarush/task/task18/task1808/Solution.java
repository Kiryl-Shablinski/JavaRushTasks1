package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/




import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws Exception{


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fIn= new FileInputStream(bufferedReader.readLine());
       FileOutputStream fOut1 = new FileOutputStream(bufferedReader.readLine());
        FileOutputStream fOut2 = new FileOutputStream(bufferedReader.readLine());
/*
        C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл для чтения.txt
        C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл для записи 1.txt
        C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\файл для записи 2.txt

 */
        byte[] buffer = new byte[fIn.available()];
        int read=fIn.read(buffer);

        if (equalBytes(read)){

            fOut1.write(buffer,0,read/2);
            fOut2.write(buffer,read/2,read/2);

        }
        if (!equalBytes(read)) {

            fOut1.write(buffer,0,read/2+1);
            fOut2.write(buffer,read/2+1,read/2);

        }
         //System.out.println(arrayList.size());


        fIn.close();
        fOut1.close();
        fOut2.close();
        bufferedReader.close();


    }

    public static boolean equalBytes(int bytes){

        if (bytes % 2 == 0) return true;
        return false;
    }


}
