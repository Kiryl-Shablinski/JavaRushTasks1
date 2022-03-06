package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {


    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> all=new ArrayList<>();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<20; i++){
            Integer s=Integer.parseInt(bufferedReader.readLine());
            all.add(s);
        }

        ArrayList<Integer> three= new ArrayList<>();
        ArrayList<Integer> two=new ArrayList<>();
        ArrayList<Integer> other=new ArrayList<>();

        for (int i=0; i<all.size(); i++){
            Integer s=all.get(i);
            if (s%3==0) three.add(s);
            if (s%2==0) two.add(s);
            if ((s%3!=0)&&(s%2!=0))other.add(s);
        }
        printList(three);
        printList(two);
        printList(other);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }


    }
}
