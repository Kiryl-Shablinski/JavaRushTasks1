package com.javarush.task.task26.task2601;



import java.util.*;


/*
Почитать в инете про медиану выборки
*/
public class Solution {



    public static void main(String[] args) {
    /*   Integer[] array =new Integer[] {13, 8, 5, 17, 15};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));

     */
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
       double median;
        Arrays.sort(array);
        if (array.length % 2 == 0){
            median = (double) (array[array.length/2] + array[array.length/2-1])/2;
        }else{
            median = array[array.length/2];
        }
        Comparator<Integer> medianShort =
                Comparator.comparingInt(value -> (int) Math.abs(median-value));

        Comparator<Integer> medianToCompare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer tmp1 = ((int) Math.abs(median-o1));
                Integer tmp2 = (int)Math.abs(median-o2);
                return tmp1.compareTo(tmp2);
            }
        };

        //Arrays.sort(array,medianShort);
        Arrays.sort(array,medianToCompare);

        return array;
    }
}
