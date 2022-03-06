package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
       if (o==this) return true;
        if (!(o instanceof Solution))
            return false;
        if (o==null || this.getClass() != o.getClass()) return false;

        Solution n = (Solution) o;
        return (n.first==first || (n.first.equals(first) && first!=null)) &&
                (n.last==last || (n.last.equals(last) && last!=null));
    }

    @Override
    public int hashCode() {
        int result =1;
        return 31* result + (first==null ? 0 : first.hashCode()) + (last==null ? 0 : last.hashCode());
    }



    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
