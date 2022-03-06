package com.javarush.task.task07.task0720;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(reader.readLine());
        int M= Integer.parseInt(reader.readLine());
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i=0; i<N;i++){
            String list=reader.readLine();
            arrayList.add(list);
        }
        for (int i=0;i<M;i++){
            String s=arrayList.get(i);
             arrayList.add(s);

        }
       for (int i=0;i<M;i++){
            arrayList.remove(0);
        }

        for (int i=0;i<arrayList.size();i++ ){

         System.out.println(arrayList.get(i));
        }



        //напишите тут ваш код
    }
}
