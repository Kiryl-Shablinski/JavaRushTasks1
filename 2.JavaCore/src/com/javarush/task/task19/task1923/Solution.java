package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fOut = new BufferedWriter(new FileWriter(args[1]));


        while(fIn.ready()){
            String line= fIn.readLine();
            String[] word = line.split(" ");
            for (String tmp : word){
                char[] simbol = tmp.toCharArray();
                for (char tmp1 : simbol){
                    if (Character.isDigit(tmp1)){
                        fOut.write(tmp);
                        fOut.write(' ');
                        break;
                    }
                }
            }
        }
        fIn.close();
        fOut.close();
    }
}
