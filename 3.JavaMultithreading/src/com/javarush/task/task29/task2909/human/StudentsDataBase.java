package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

   /*7..2
    public static void addInfoAboutStudent(String name, int age, double averageGrade) {
        Student student = new Student(name, age, averageGrade);
        students.add(student);
        printInfoAboutStudent(student.getName(), student);
}
    */

    public static void addInfoAboutStudent(Student student){
        students.add(student);
        printInfoAboutStudent(student);
    }

    /* 7..3
    public static void printInfoAboutStudent(String name, Student student) {
        System.out.println("Имя: " + name + " Возраст: " + student.getAge());
    }

     */
    //7..3
    public static void printInfoAboutStudent(Student student){
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    //8..3
    public static void removeStudent(int index) /*throws IndexOutOfBoundsException*/ {
        if (index>=0 && index<students.size()) students.remove(index);
    }

    public static void findDimaOrSasha() {
       //8..4
        // boolean found = false;
        for (int i = 0; i < students.size(); i++) {
          //  if (!found)

               if (students.get(i).getName().equals("Dima")){
                    System.out.println("Студент Dima есть в базе.");
                    break;
                   // found = true;
                }

                if (students.get(i).getName().equals("Sasha")) {
                    System.out.println("Студент Sasha есть в базе.");
                    break;
                    //found = true;
                }
        }
    }
}