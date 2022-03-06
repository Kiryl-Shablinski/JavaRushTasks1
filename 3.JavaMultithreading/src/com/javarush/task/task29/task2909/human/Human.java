package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
   //8..2 private
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    //3..1
    // protected int course;

    private List<Human> children = new ArrayList<>();

    //9..2
    //protected int[] size;
    protected Size size;

    //2..2
    //  protected boolean isSoldier;

    /*9..8
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;

     */
   //9..7
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
      this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    //1..3. не модифицироваееый список
    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

   /*4 public void setChildren(List<Human> children) {this.children = children;}
 */

    public int getAge() {
        return age;
    }

   /*8..1
    public void setAge(int age) {this.age = age;}
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* 3..2
    public int getCourse() {return course;}
    */

   /*2.. 3
   public void live() {if (isSoldier) fight();}

    public void fight() {}
    */

    @Override
    public void live() {

    }

    public int getId() {
        return id;
    }

   /* 8..1 public void setId(int id) {
        this.id = id;
    }

    */

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void addChild(Human child) {
        children.add(child);

    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    //5..1
    public String getPosition() {
        return "Человек";
    }

   //5..4
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

   //9..2
    public class Size{
        public int height;
        public int weight;

        public Size(){}
    }
}