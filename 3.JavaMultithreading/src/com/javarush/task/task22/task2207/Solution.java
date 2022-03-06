package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedReader fIn = new BufferedReader(new FileReader(bufferedReader.readLine()));
//C:\\Users\\kirya\\Documents\\Java Multithreading\\level 2\\обращенные слова\\FileInput.txt
        bufferedReader.close();
       StringBuilder stb=null;
        ArrayList<String> list = new ArrayList<>();

        while (fIn.ready()){
            list.addAll(Arrays.asList(fIn.readLine().split("\\s")));
        }
        for (int i=0; i<list.size();i++){
            for (int j=i+1; j<list.size();j++){
                stb= new StringBuilder(list.get(j));
                if (list.get(i).contentEquals(stb.reverse())){
                    Pair pair = new Pair();
                    pair.first=list.get(i);
                    pair.second = list.get(j);
                    if (contansPair(result, pair)) {
                        result.add(pair);
                    }

                }

            }
        }

        System.out.println(result);

    }

    public static boolean contansPair(List<Pair> list,Pair pair){
        for (Pair tmp : list){
            if (tmp.equals(pair)) return false;
        }
        return true;
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
