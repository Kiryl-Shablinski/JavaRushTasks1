package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human child=new Human("mariya", false,5);
       Human child2=new Human("ksenija",false,6);
       Human child3=(new Human("valerija",false,1));

        Human father=new Human("kiryl",true,34);
        father.children.add(child);
        father.children.add(child2);
        father.children.add(child3);

        Human mother=new Human("natasha",false,32);
        mother.children.add(child);
        mother.children.add(child2);
        mother.children.add(child3);

        Human grandfather=new Human("sasha",true,60);
        grandfather.children.add(father);


        Human grandmother=new Human("galja",false,59);
        grandmother.children.add(father);


        Human grandfather1=new Human("misha",true,54);
        grandfather1.children.add(mother);

        Human grandmother1=new Human("lena",false,56);
        grandmother1.children.add(mother);

        System.out.println(grandfather.toString());
        System.out.println(grandfather1.toString());
        System.out.println(grandmother.toString());
        System.out.println(grandmother1.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());



    }

    public static class Human {
        //напишите тут ваш код

          String name;
         Boolean sex;
         int age;
         ArrayList<Human> children=new ArrayList<>();

        Human(String name, boolean sex,int age){
           this.name=name;
           this.sex=sex;
           this.age=age;
       }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
