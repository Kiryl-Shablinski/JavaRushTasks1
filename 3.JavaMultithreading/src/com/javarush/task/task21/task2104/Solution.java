package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Solution)) return false;
        if (o==null || this.getClass() != o.getClass()) return false;
        Solution n =(Solution) o;

        return (first==n.first|| first!=null && first.equals(n.first)) &&
                (last==n.last || last!=null && last.equals(n.last));
    }




    @Override
    public int hashCode() {
        int result = 1;
        return 31*result + ((first==null) ? 0 :first.hashCode()) + ((last==null) ? 0 : last.hashCode());
    }





    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution s1 =new Solution("Donald", "Duck");
        //System.out.println("HashCode first s1: " + s1.first.hashCode());
        //System.out.println("HashCode last s1: " + s1.last.hashCode());
        //System.out.println("HashCode s1: " + s1.hashCode());

        s.add(s1);

        Solution solution=new Solution("Donald", "Duck");
        //System.out.println("HashCode first solution: " + solution.first.hashCode());
        //System.out.println("HashCode last solution: " + solution.last.hashCode());
        //System.out.println("HashCode solution: " + solution.hashCode());

        System.out.println(s1.first.equals(solution.first));
        System.out.println(s1.last.equals(solution.last));
        System.out.println(s1.equals(solution));

        System.out.println(s.contains(solution));

    }
}
