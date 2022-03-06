package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader fIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fOut = new BufferedWriter(new FileWriter(args[1]));

        while (fIn.ready()){
           String []  stB =fIn.readLine().split("[\\s ]");

           for (int i=0; i<stB.length;i++) {

               if (stB[i].length() > 6) {
                   list.add(stB[i]);
               }

           }
        }

        for (int i=0; i<list.size();i++){
            if (i==list.size()-1){
                fOut.write(list.get(i));
            }else{
                fOut.write(list.get(i));
                fOut.write(',');
            }
        }

        fIn.close();
        fOut.close();

    }
}
