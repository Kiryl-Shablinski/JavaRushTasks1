package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {


    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
      //  for (Cat cat:cats){
       //     cats.remove(cat);
        //    break;
        //}
        Iterator<Cat> catIterator=cats.iterator();
        cats.remove(catIterator.next());



        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> set=new HashSet<>();
        set.add(new Cat());
        set.add(new Cat());
        set.add(new Cat());
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat set:cats) {
            System.out.println(set);

        }
    }
    public static class Cat{

        public Cat(){

        }
    }

    // step 1 - пункт 1
}
