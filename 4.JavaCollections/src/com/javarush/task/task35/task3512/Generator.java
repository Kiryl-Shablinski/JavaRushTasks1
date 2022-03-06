package com.javarush.task.task35.task3512;



public class Generator<T> {
     Class<T> tClass;

     public Generator (Class<T> tClass)  {
         this.tClass = tClass;
     }

    T newInstance() {
        T type = null;
        try {
            type = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return type;
    }
}
