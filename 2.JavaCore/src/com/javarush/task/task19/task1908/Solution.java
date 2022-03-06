package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter fOut = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        //C:\\tmp\\Выделяем числа\\входной файл.txt
        //C:\\tmp\\Выделяем числа\\выходной файл.txt

        while(fIn.ready()){
            String text = fIn.readLine();
            String[] word = text.split(" ");
            for (String number : word){

                if (isNumeric(number)) {

                    fOut.write(number);
                    fOut.write(" ");
                }


            }
        }
        fIn.close();
        fOut.close();
    }

    public static boolean isNumeric (String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException o){
            return false;
        }
    }
}
