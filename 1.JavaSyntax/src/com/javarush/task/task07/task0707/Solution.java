package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> arrayList=new ArrayList();
        for (int i=0; i<5; i++){
            arrayList.add("Програмирование на java "+i);
        }
        System.out.println(arrayList.size());

        for (int i=0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

    }
}
