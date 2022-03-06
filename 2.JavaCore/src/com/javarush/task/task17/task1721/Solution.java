package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)  {
        Solution solution=new Solution();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try {
            FileReader fileFirst = new FileReader(bufferedReader.readLine());//"C:\\Users\\kirya\\Программирование\\firstFileName.txt";
            FileReader fileSecond = new FileReader(bufferedReader.readLine());//"C:\\Users\\kirya\\Программирование\\secondFileName.txt";
            readerallLines(fileFirst);
            readerRemovLines(fileSecond);

          // System.out.println(allLines.toString());
         // System.out.println(forRemoveLines.toString());

            solution.joinData();

           // System.out.println(allLines.toString());
           // System.out.println(forRemoveLines.toString());
            bufferedReader.close();


        } catch (IOException e){
           // System.out.println("в списке forRemoveLines нет файлов allLines");

        }






    }

    public static void readerallLines(FileReader file){
       BufferedReader bufferedReader=new BufferedReader(file);
      try {
          String text = bufferedReader.readLine();
          while (text!=null) {
              allLines.add(text);
              text=bufferedReader.readLine();
          }
          bufferedReader.close();
      }catch (IOException o){
          o.printStackTrace();
      }
    }

    public static void readerRemovLines(FileReader file){
        BufferedReader bufferedReader=new BufferedReader(file);
        try {
            String text = bufferedReader.readLine();
            while (text!=null) {
                forRemoveLines.add(text);
                text=bufferedReader.readLine();

            }

        }catch (IOException o){
            o.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw  new CorruptedDataException();

        }

    }
}
