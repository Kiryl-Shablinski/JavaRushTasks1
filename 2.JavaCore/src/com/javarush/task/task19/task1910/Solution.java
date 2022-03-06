package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/



import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn = new BufferedReader( new FileReader(bufferedReader.readLine()));
        BufferedWriter fOut = new BufferedWriter( new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Пунктуация\\Входной.txt
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Пунктуация\\Выходной.txt

        while (fIn.ready()){
            String line =fIn.readLine();
            String[] text= line.split("\\p{Punct}");

            for (String word : text){
                fOut.write(word);
            }
        }

        fIn.close();
        fOut.close();

    }
}
