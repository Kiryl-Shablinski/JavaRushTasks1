package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.*;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix(m);
        printMatrix((long)n);
        printMatrix(n, value);
        printMatrix((float)m,(float) n,value);

    }

    public static void printMatrix( int m){
        System.out.println("Выводим колличество строк матрицы "+m);

    }

    public static void printMatrix( long n){
        System.out.println("Выводим колличество столбцов матрицы "+n);
    }

    public static void printMatrix(int n,Object value){
        System.out.print("Выводим  элементы строки ");
        for (int i=0;i<n;i++){
            System.out.print(value);
        }
        System.out.print("\n");
       String value1=(String) value;
        printMatrix(n, parseInt(value1));

    }

    public static void printMatrix(int n,Integer value){
       int value1=0, result;

        for (int i=0;i<n;i++){
            result=value+value1;
        System.out.print((result)+" ");
        value1=result;
        }
        System.out.println();
    }
    public static void printMatrix(float m, float n,Object value){
        System.out.println("Float "+m+n);
    printMatrix((double)m,n,value);
    }
    public static void printMatrix(double m,float n,Object value){
        System.out.println("Double m");
    printMatrix(m,(double) n,value);
    }
    public static void printMatrix(double m, double n, Object value){
        System.out.println("Double "+m+" "+n);
        printMatrix((Double)m,(Double)n,value);
    }
    public static void printMatrix(Double m, Double n, Object value){
        System.out.println("Max class");
    }

}
