package com.javarush.task.task20.task2025;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> resultList = new ArrayList<>();
        if (N>0) {

            for (long S = 1; S < N; S++) {
                List<Long> list = new ArrayList<>();

                for (long a = S; a > 0; a /= 10) {

                    list.add(0, a % 10);
                }
                long summ = 0;
                for (int i = 0; i < list.size(); i++) {
                    summ += Math.pow(list.get(i), list.size());
                }
                if (summ == S) {
                    resultList.add(summ);
                }
            }

            result = new long[resultList.size()];

            for (int j = 0; j < result.length; j++) {
                result[j] = resultList.get(j);
            }
        }


        return result;
    }




    public static void main(String[] args){
        Date dateStart = new Date();
       System.out.println(Arrays.toString(getNumbers(10000000)));
       Date dateFinish = new Date();
        System.out.println("Time " + (dateFinish.getTime()-dateStart.getTime())/1000);
        long memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Memory " + memory/1048576);


    }
}
