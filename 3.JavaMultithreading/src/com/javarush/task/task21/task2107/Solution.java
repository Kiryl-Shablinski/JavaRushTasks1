package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public int hashCode() {
      int result = super.hashCode()+ users.hashCode();
      return  result;
    }

    @Override
    public boolean equals(Object obj) {
       if (this==obj) return true;
       if (obj==null || this.getClass()!= obj.getClass()) return false;
       Solution solution = (Solution) obj;
       if (users!=null ? !users.containsKey(obj) : obj!= null) return false;

        return true;
    }

    @Override
    public Solution clone() throws CloneNotSupportedException {
       Solution clone= new Solution();
       for(Map.Entry<String, User> pairclone : users.entrySet()){
           clone.users.put(pairclone.getKey(),pairclone.getValue().clone());
        }
       return clone;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
           User clone= (User) super.clone();
           clone.age=age;
           clone.name=name;
           return clone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
