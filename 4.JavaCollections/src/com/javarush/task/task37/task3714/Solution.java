package com.javarush.task.task37.task3714;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
       // test();
    }



    public static int romanToInteger(String s) {
     int result = 0;
     char[] sRom = s.toCharArray();

     Map<Character, Integer> mapRom = createMapRom();
        for (int  i = sRom.length - 1 ; i >= 0; i--) {
            int tmp = mapRom.get(sRom[i]);
            if (i != 0 && (mapRom.get(sRom[i -1]) < tmp)){
                result -= mapRom.get(sRom[i-1]);
                i--;
            }
            result += tmp;

        }
        return result;
    }



    private static Map<Character, Integer> createMapRom(){
        Map <Character, Integer> map = new  HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

  /*  private static void test() {
        Object[][] tests = new Object[][]{
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {9, "IX"},
                {12, "XII"},
                {16, "XVI"},
                {29, "XXIX"},
                {44, "XLIV"},
                {45, "XLV"},
                {68, "LXVIII"},
                {83, "LXXXIII"},
                {97, "XCVII"},
                {99, "XCIX"},
                {500, "D"},
                {501, "DI"},
                {649, "DCXLIX"},
                {798, "DCCXCVIII"},
                {891, "DCCCXCI"},
                {1000, "M"},
                {1004, "MIV"},
                {1006, "MVI"},
                {1023, "MXXIII"},
                {2014, "MMXIV"},
                {3999, "MMMCMXCIX"}
        };

        Arrays.stream(tests)
                .forEach(objects -> {
                            final int expected = (Integer) objects[0];
                            final String input = (String) objects[1];
                            final int real = romanToInteger(input);

                            System.out.printf(
                                    "input: %10s\t\texpected: %5s\t\treal: %5s\t\tTest: %5s%n",
                                    input, expected, real, expected == real);
                        }
                );
    }

   */
    @Test
    public void testRoman(){
        String test2014 = "MMXIV";
        String test3456 = "MMMCDLVI";
        Assert.assertEquals(2014, romanToInteger(test2014));
        Assert.assertEquals(3456, romanToInteger(test3456));
    }
}
