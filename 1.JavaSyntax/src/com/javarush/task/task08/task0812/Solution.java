package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
       List<Integer> arrayList = new ArrayList<>();
       //LinkedList arrayList1lenght=new LinkedList();

        numberinsert(arrayList);
        System.out.println(Containslong(arrayList));




    }

    public static void numberinsert(List list) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(bufferedReader.readLine());
            list.add(x);
        }
    }

    public static int Containslong(List list) {
        int containslist = 1;
        int max=1;

         for (int i = 0; i < list.size(); i++) {
            if ((i+1) == list.size()) {
               // System.out.println("stop");
                break;

            }
              if (list.get(i).equals(list.get(i + 1))) {
              //  System.out.println(list.get(i).equals(list.get(i+1)));
                containslist++;
                if (containslist>=max) max=containslist;
               // listlenght.add(containslist);
            }
            else containslist=1;

        }
         return max;
    }

}