package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);

        }
        // System.out.println(exceptions.size());
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        }catch (Exception e) {
            exceptions.add(e);
        }

        try{
            throw new ClassCastException();

        }catch (ClassCastException a){
            exceptions.add(a);
        }

        try{
            throw new IllegalMonitorStateException();

        }catch (IllegalMonitorStateException e){
            exceptions.add(e);
        }

        try{
            throw new NumberFormatException();

        }catch (NumberFormatException e){
            exceptions.add(e);
        }

        try{
            throw new ArrayIndexOutOfBoundsException();

        }catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);

        }

        try{
            throw new ArrayStoreException();

        }catch (ArrayStoreException e){
            exceptions.add(e);

        }

        try{
            throw new MyException();

        }
        catch (MyException e){
            exceptions.add(e);

        }

        try{
            throw new IllegalThreadStateException();

        }catch (IllegalThreadStateException e){
            exceptions.add(e);

        }

        try{
            throw new NegativeArraySizeException();

        }catch (NegativeArraySizeException e) {
            exceptions.add(e);

        }

        try{
            throw new IllegalAccessException();

        }catch (IllegalAccessException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
    static class MyException extends Exception{

    }
}
