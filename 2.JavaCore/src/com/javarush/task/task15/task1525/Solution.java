package com.javarush.task.task15.task1525;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {

    public static  List<String> lines = new ArrayList<String>();
    static {

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(Statics.FILE_NAME));
            String text=bufferedReader.readLine();

            while (text!=null){
                lines.add(text);
                text=bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException s){
            s.printStackTrace();
        }


    }





    public static void main(String[] args) {
        System.out.println(lines);
    }


}
