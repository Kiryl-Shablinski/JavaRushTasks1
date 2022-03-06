package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn= null;
        BufferedWriter fOut= null;
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Замена знаков\\входной.txt
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Замена знаков\\выходной.txt
        try{
             fIn = new BufferedReader( new FileReader(bufferedReader.readLine()));
             fOut = new BufferedWriter( new FileWriter(bufferedReader.readLine()));

            while (fIn.ready()){
                StringBuilder builder = new StringBuilder(fIn.readLine());
                String text =builder.toString().replace(".","!");
                fOut.write(text);
            }


        }catch (IOException o){
            o.getMessage();
        }
        finally {
            try {
                bufferedReader.close();
                fIn.close();
                fOut.close();
            }catch (IOException e){
                e.getMessage();
            }

        }
    }
}
