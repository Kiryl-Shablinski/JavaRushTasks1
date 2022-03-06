package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();

        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();

        String line;

        while ((line=reader.readLine())!=null){

            list.add(line);
        }

        for (String id : list){

            if (id.startsWith(args[0]+" ")){
                System.out.println(id);
            }
        }

        reader.close();

    }
}
