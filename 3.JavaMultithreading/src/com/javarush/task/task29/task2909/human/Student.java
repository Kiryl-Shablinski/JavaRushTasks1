package com.javarush.task.task29.task2909.human;


import java.util.Date;


public class Student extends UniversityPerson {
    //1..1.private List<Human> children = new ArrayList<>();
    private double averageGrade;
   //4..8
   // private String university;
    private Date beginningOfSession;
    private Date endOfSession;

    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
       // this.name = name;
       // this.age = age;
        this.averageGrade = averageGrade;
    }

  /* 1..2. public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

   */

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

  /* 4..9
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

   */

    /*5..4
    public void printData() {
        System.out.println( "Студент" + name);
    }

     */

    /* 7..1
    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }

     */
    //7..1
    public void incAverageGrade(double delta){
        //9..1
        // averageGrade+=delta;
        setAverageGrade(getAverageGrade()+delta);

    }

   /* 6..1
    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }

    */
    //6..1
    public void setCourse(int course){
        this.course = course;

    }

    //6..1
    public void setAverageGrade(double averageGrade){
       this.averageGrade = averageGrade;
    }

   //7..4
   // public void setBeginningOfSession(int day, int month, int year) {
   //     beginningOfSession = new Date(year, month, day);
   // }
    //
    public void setBeginningOfSession(Date date){
        beginningOfSession = date;
    }

   //7..5 public void setEndOfSession(int day, int month, int year) {
   //     endOfSession = new Date(year, month, day);
   // }
    //

    public void setEndOfSession(Date date){
        endOfSession =date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    //5..2
    @Override
    public String getPosition() {
        return "Студент";
    }
}