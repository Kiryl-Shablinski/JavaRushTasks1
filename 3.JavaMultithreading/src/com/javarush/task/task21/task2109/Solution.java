package com.javarush.task.task21.task2109;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }

        @Override
        public String toString() {
            return "i " + getI() + " : " + "j " + getJ();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return getI() == a.getI() &&
                    getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public B clone() throws CloneNotSupportedException {
            super.clone();
            throw new CloneNotSupportedException();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            B b = (B) o;
            return Objects.equals(getName(), b.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getName());
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException {

           C clone = new C(super.getI(),super.getJ(),super.getName());

           return clone;
        }

        @Override
        public String getName() {
            return super.getName();
        }




        @Override
        public String toString() {
            return super.toString() + " : name " + getName();
        }
    }

    public static void main(String[] args) {
        A a=new A(2,3);
        C c = new C(4, 5,"Kiryl");
        A b  = new B(6,7,"Iryna");
        A clone =null;
        C clone1 = null;
        B clone2 = null;
        try{
            clone= a.clone();
            clone1 = (C) c.clone();
           // clone2 = (B) b.clone();
            System.out.println(a);
            System.out.println(c);
            System.out.println(b);
            System.out.println(clone);
            System.out.println(clone1);
            System.out.println(clone2);




        }catch (CloneNotSupportedException o){
            o.printStackTrace(System.err);
        }

    }
}
