package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private Human mother;
        private Human father;
        private boolean sex;
        private String adress;

        public Human(){}

        public Human(boolean sex){
            this.sex=sex;
        }

        public Human(String name,int age){
            this.name=name;
        }

        public Human(String name){
            this.name=name;
        }

        public Human(String name,int age,boolean sex,Human mother){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.mother=mother;
        }

        public Human(String name,int age,boolean sex,Human mother, Human father){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.mother=mother;
            this.father=father;
        }

        public Human(String name,int age,boolean sex, String adress){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.adress=adress;
        }

        public Human(String name,int age,boolean sex,Human mother, Human father,String adress){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.mother=mother;
            this.father=father;
            this.adress=adress;
        }

        public Human(String name,Human human){
            this.name=name;
        }

        public Human(String name, boolean sex){
            this.name=name;
            this.sex=sex;
        }

    }
}
