package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
       // strings.add("роза");
        // strings.add("мера");
        //strings.add("лоза");
        //strings.add("лира");
        //strings.add("вода");
        //strings.add("упор");
        strings.add("колокол");
        strings.add("лаборатория");
        strings.add("рупор");


        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);


        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код



        for (int i=0; i<strings.size();) {

            String str = strings.get(i);

            if (str.contains("р") && str.contains("л")){

            }

            if (!str.contains("р")&&str.contains("л")){

                    strings.add(i,str);
                    i++;
            }



            if (str.contains("р") && !str.contains("л")) {

                    strings.remove(str);
                    i--;
            }

            i++;
        }


        return strings;
    }
}