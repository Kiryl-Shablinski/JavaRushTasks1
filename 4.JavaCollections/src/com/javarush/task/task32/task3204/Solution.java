package com.javarush.task.task32.task3204;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        StringBuilder password = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean numeralFlag = false;
        boolean lowerSymbolFlag = false;
        boolean upperSymbolFlag = false;


      while (!numeralFlag | !lowerSymbolFlag | !upperSymbolFlag) {

          password = new StringBuilder();
          while (password.length() != 8) {
              char symbol = (char) passwordSymbol(rnd(48, 57), rnd(97, 122), rnd(65, 90));
              if (symbol >= 48 && symbol <= 57) numeralFlag = true;
              if (symbol >= 97 && symbol <= 122) lowerSymbolFlag = true;
              if (symbol >= 65 && symbol <= 90) upperSymbolFlag = true;
              password.append(symbol);
          }
      }
        out.write(password.toString().getBytes());

      return out;
    }

    private static int passwordSymbol(int numeral, int lowerSymbol, int upperSymbol){
        int [] array = {numeral,lowerSymbol, upperSymbol};
        int randomIndex = new Random().nextInt((array.length));
        return  array[randomIndex];
    }

    private static int rnd ( int min, int max){
        max-= min;

        return (int) (Math.random() *  max) + min;
    }
}
