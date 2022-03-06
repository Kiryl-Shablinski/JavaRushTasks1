package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {

    public static volatile boolean stopProgramm=true;

    public static void main(String[] args) {

        //C:\\tmp\\simbol.txt
        //C:\\tmp\\result.txt

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (stopProgramm) {
                new MyThread(bufferedReader.readLine()).start();
            }
            bufferedReader.close();
        }catch (IOException e){
            e.getMessage();
        }

    }

    public static class MyThread extends Thread {

        private String fileName;

       public MyThread(String fileName){
           this.fileName = fileName;

       }

        @Override
        public void run() {

            FileInputStream fIn = null;

           try {
                fIn = new FileInputStream(fileName);
               fIn.close();

           }catch (FileNotFoundException p){

               System.out.println(fileName);
               stopProgramm = false;

           }catch (IOException o){
               o.printStackTrace();

           }


        }
    }
}
