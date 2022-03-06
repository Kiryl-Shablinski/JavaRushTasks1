package com.javarush.task.task29.task2909.human;



public class Teacher extends UniversityPerson{
  //1..1.  private List<Human> children = new ArrayList<>();
    private int numberOfStudents;
   //4..8
   // private String university;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
       // this.name = name;
       // this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

   /*1..2. public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    */

    public void live() {
        teach();
    }

    public void teach() {
    }

   /*4..9 public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    */

   /*5..5
    public void printData() {
        System.out.println("Преподаватель" + name);
    }

    */

  //5..3
    @Override
    public String getPosition() {
        return "Преподаватель";
    }
}