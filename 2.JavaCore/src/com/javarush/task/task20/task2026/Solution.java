package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 1, 0}
        };
        byte[][] a4 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };


        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 6");
        int count4 = getRectangleCount(a4);
        System.out.println("count = " + count4 + ". Должно быть 5");
    }

    public static int getRectangleCount(byte[][] a) {
        int countRectangle=0;
        int startHight = 0, finishHight = 0, startWight = 0, finishWight = 0;

        for (int i=0; i<a.length;i++){
            for (int j=0; j<a[i].length;j++){

                if (a[i][j]==1){
                    countRectangle++;
                    startHight=i;
                    startWight=j;

                    while(j<a[i].length && a[i][j]==1){
                       finishWight=j;
                       j++;
                    }
                    j-=1;

                    while (i<a.length && a[i][j]==1){
                        finishHight=i;
                        i++;
                    }
                    i=startHight;
                    j=startWight;

                    clearRectangle(a,startWight,finishWight,startHight,finishHight);
                }
            }
        }
        return countRectangle;
    }

    public static void clearRectangle(byte[][]a, int startWight,int finishWight, int startHight, int finisjHight){
        for (int i=startHight; i<=finisjHight; i++){
            for (int j=startWight; j<=finishWight; j++){
                a[i][j]=0;
            }
        }
    }
}
