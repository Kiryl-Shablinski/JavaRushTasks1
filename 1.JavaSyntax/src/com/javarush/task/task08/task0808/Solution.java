package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list) {
        //напишите тут ваш код
        Date startTime=new Date();
        for (int i=0; i<10000;i++){
           list.add(0,new Object());
        }
        Date finishTime=new Date();
        long insertTime=finishTime.getTime()-startTime.getTime();
        System.out.println("insert "+insertTime);

    }

    public static void get10000(List list) {
        //напишите тут ваш код
        Date startTime=new Date();
        for (int i=0;i<10000;i++){
         list.get(i);
          }
        Date finishTime=new Date();
        long insertTime=finishTime.getTime()-startTime.getTime();
        System.out.println("get "+insertTime);


    }

    public static void set10000(List list) {
        //напишите тут ваш код

        Date startTime=new Date();
        for (int i=0; i<10000;i++){
            list.set(i,new Object());
        }
        Date finishTime=new Date();
        long insertTime=finishTime.getTime()-startTime.getTime();
        System.out.println("set "+insertTime);

    }

    public static void remove10000(List list) {
        //напишите тут ваш код
        Date startTime=new Date();
        for (int i=0; i<10000;i++){
            list.clear();
        }
        Date finishTime=new Date();
        long insertTime=finishTime.getTime()-startTime.getTime();
        System.out.println("remov "+insertTime);

    }
}
