package com.javarush.task.task14.task1420;

/* 
НОД
*/



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            Integer a = Integer.parseInt(bufferedReader.readLine());
            Integer b = Integer.parseInt(bufferedReader.readLine());

            if (!(a instanceof Integer)||!(b instanceof Integer)){
                throw new MyException();
            }
            if (a<=0||b<=0){
                   throw new MyException();
            }

            System.out.println(nod(a, b));
    }
    public static boolean comparison(int a, int b){
        if (a<b) return false;
        return true;
    }

    public static Integer nod(int x, int y){
        int a=0,b=0,tmp=0,nod=1;

        if (comparison(x, y)){
            a=x;
            b=y;

        }else{
            a=y;
            b=x;
        }

        while (nod>0) {
            nod = a % b;

            if (nod==0){
                break;
            }

            a=b;
            b=nod;
        }

        nod=b;
        return nod;
    }
    public static class MyException extends Exception{

    }

}
