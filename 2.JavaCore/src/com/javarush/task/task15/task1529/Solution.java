package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
       try{
        reset();
       }catch (IOException o){
           o.printStackTrace();
       }



    }

    public static CanFly result;

    public static void reset() throws IOException{
        //add your code here - добавьте код тут
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        try{
            String text=bufferedReader.readLine();
            if (text.equals("plane")){
               int countPassanger= Integer.parseInt(bufferedReader.readLine());
               result=new Plane(countPassanger) ;
            }
            if (text.equals("helicopter")){
                result=new Helicopter();
            }
        }catch (IOException o){
            o.printStackTrace();
        }
        bufferedReader.close();



    }

}
