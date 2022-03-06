package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList=new ArrayList<>();

        try {
            while (true){
            int a = Integer.parseInt(bufferedReader.readLine());
            arrayList.add(a);
            }
        }
        catch (NumberFormatException e){
            for (Integer list:arrayList){
                System.out.println(list);
            }
        }
        catch (IOException e) {
            for (Integer list : arrayList) {
                System.out.println(list);
            }
        }
    }
}
