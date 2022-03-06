package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

       ArrayList<Human> human=new ArrayList<>();
        human.add(new Human("Галина",false,58));
        human.add(new Human("Анна",false,53));
        human.add(new Human("Александр",true,60));
        human.add(new Human("Михаил",true,55));
        human.add(new Human("Кирилл",true,34,human.get(2),human.get(0)));
        human.add(new Human("Ирина",false,29,human.get(3),human.get(1)));
        human.add(new Human("Мария", false, 5,human.get(4),human.get(5)));
        human.add(new Human("Настя", false, 7,human.get(4),human.get(5)));
        human.add(new Human("Дмитрий", true, 1,human.get(4),human.get(5)));


        for (Human s: human){
            System.out.println(s);
        }




    }

    public static class Human {
        // напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

       public Human(){}

        public Human(String name, boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
        }
        public Human(String name, boolean sex, int age,Human father,Human mother){
           this.name=name;
           this.sex=sex;
           this.age=age;
          this.father=father;
          this.mother=mother;

        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}