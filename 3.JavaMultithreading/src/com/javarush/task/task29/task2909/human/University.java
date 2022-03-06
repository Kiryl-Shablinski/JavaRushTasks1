package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University /*4..1extends Student*/ {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

//4..

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //6..2
    public Student getStudentWithAverageGrade(double averageGrade) {
       for (Student student : students){
           if (student.getAverageGrade()!=0) {
               if ((double) student.getAverageGrade() == averageGrade) return student;
           }
       }
       return null;
    }

        //6..3
    public Student getStudentWithMaxAverageGrade() {
        Student studentMaxAverageGrade = students.get(0);
        for (Student student : students){

            studentMaxAverageGrade= (student.getAverageGrade()>studentMaxAverageGrade.getAverageGrade())
                    ? student : studentMaxAverageGrade;
       }
        return studentMaxAverageGrade;
    }

    /*6..4

    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }

     */
    public Student getStudentWithMinAverageGrade(){
        Student studentMinAverageGrade = students.get(0);
        for (Student student : students){

            studentMinAverageGrade= (student.getAverageGrade()<studentMinAverageGrade.getAverageGrade())
                    ? student : studentMinAverageGrade;
        }
        return studentMinAverageGrade;
    }

    public void expel(Student student){
        if (student!=null){
            students.remove(student);
        }
    }
}