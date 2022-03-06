package com.javarush.task.task18.task1823;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        while (!(text = bufferedReader.readLine()).equals("exit")){

            new ReadThread(text).start();
        }

       /* for (Map.Entry<String, Integer> pair : resultMap.entrySet()){

            System.out.println(pair.getKey() + " - " + pair.getValue());
        }*/

        bufferedReader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int max = 0;
            try {
                FileInputStream fIn = new FileInputStream(fileName);
                byte[] bytes = new byte[256];

                addByte(bytes, fIn);
                max= maxByteCount(bytes, max);

               bytePrint(bytes, max);


               fIn.close();


            }catch (Exception o){
                o.getMessage();
            }


        }

        public  void addByte (byte[] bytes, FileInputStream fIn) throws Exception{

            while (fIn.available() > 0) {
                bytes[fIn.read()] += 1;
            }

        }


        public  int maxByteCount(byte[] bytes, int max){

            for (int i=0; i<bytes.length;i++){
                max = Math.max(max,bytes[i]);
            }
            return max;
        }

        public  void bytePrint (byte[] bytes, int max){

            for (int i=0; i<bytes.length;i++){
                if (bytes[i]==max){

                        resultMap.put(fileName,i);

                }
            }

        }
    }
}
