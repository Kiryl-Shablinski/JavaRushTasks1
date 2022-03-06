package com.javarush.task.task23.task2305;



/*
Inner
*/
public class Solution {
       public InnerClass[] innerClasses = new InnerClass[2];

    public  class InnerClass {

    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];

      for (int j=0; j<solutions.length;j++){
          solutions[j]=new Solution();

          for (int i=0; i<solutions[j].innerClasses.length;i++){
             solutions[j].innerClasses[i]=solutions[j].new InnerClass();
          }
      }
      return solutions;
    }

    public static void main(String[] args) {


    }
}
