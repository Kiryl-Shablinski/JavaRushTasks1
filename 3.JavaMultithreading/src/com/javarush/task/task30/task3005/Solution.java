package com.javarush.task.task30.task3005;

import java.util.ArrayList;
import java.util.List;

/* 
Такие хитрые исключения!
*/

public class Solution {
    public static void main(String[] args) {
        checkAFlag(new D());
        checkAFlag(null);


    }

    public static void checkAFlag(D d) {
       try {
           if (d.cs.get(0).bs.get(0).as.get(0).flag) {
               System.out.println("A's flag is true");
           }/* else //all other cases
           if (d == null || d.cs == null || d.cs.isEmpty() ||
                   d.cs.get(0).bs == null || d.cs.get(0).bs.isEmpty() ||
                   d.cs.get(0).bs.get(0).as == null || d.cs.get(0).bs.get(0).as.isEmpty() ||
                   !d.cs.get(0).bs.get(0).as.get(0).flag) {
            */
           if (!d.cs.get(0).bs.get(0).as.get(0).flag)  System.out.println("Oops!");
       }catch (Exception o){

               System.out.println("Oops!");
           }

    }

    static class A {
        boolean flag = true;
    }

    static class B {
        List<A> as = new ArrayList<>();

        {
            as.add(new A());
        }
    }

    static class C {
        List<B> bs = new ArrayList<>();

        {
            bs.add(new B());
        }
    }

    static class D {
        List<C> cs = new ArrayList<>();

        {
            cs.add(new C());
        }
    }
}