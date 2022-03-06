package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.io.*;





public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream bufferInt = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));
        BufferedOutputStream buferOut = new BufferedOutputStream(new FileOutputStream(bufferedReader.readLine()));
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\Числа для ввода.txt
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 8\\Числа для вывода.txt

       byte[] buffer = new byte[bufferInt.available()];

       if (bufferInt.available()>0){
           bufferInt.read(buffer);
            String text = new String(buffer);

           int[] n = rounding(parsing(text));
           text=intString(n);
         //  System.out.println(text);
          buffer = text.getBytes();
          buferOut.write(buffer);

        }
        bufferedReader.close();
        bufferInt.close();
        buferOut.close();

    }

    public static int[] rounding ( double[] number){

        int[] n= new int[number.length];
        for (int i=0; i<number.length;i++) {
           // double x = Math.rint(number[i]);
           // double y = number[i];
            // number[i]=Math.rint(number[i])-1;
            if (((int) number[i]-number[i])==0.5){

                n[i] = (int) number[i];

            }else{

            n[i] = (int) Math.rint(number[i]);

            }
        }
        return n;
    }

    public static double[] parsing(String text) throws Exception{

        String[] text1 = text.split(" ");
        double[] number = new double[text1.length];
       //System.out.println(text);
        for (int i=0; i<text1.length; i++) {
           number[i] = Double.parseDouble(text1[i]);
        }

        return number;
    }

    public static String intString(int[] number){
       String text=" ";
        for (Integer liter : number){
          text += liter.toString()+" ";
        }
        return text.trim();
    }


}
