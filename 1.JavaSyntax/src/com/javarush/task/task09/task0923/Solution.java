package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        List<String> listClass=new ArrayList<>();
        List<String> listConsonant=new ArrayList<>();

        //напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
       String text=bufferedReader.readLine();

      char[] c=text.toCharArray();
      char space=' ';
      for (int i=0;i<c.length;i++){

          if (c[i]==space){
              continue;
          }
          else {

              if (isVowel(c[i]) == true) {
                  listClass.add(Character.toString(c[i]));
              } else {
                  listConsonant.add(Character.toString(c[i]));
              }
          }
       }
       for (String list:listClass){
           System.out.print(list+" ");

       }
        System.out.println();
       for (String list:listConsonant){
           System.out.print(list+" ");
       }


    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }

}