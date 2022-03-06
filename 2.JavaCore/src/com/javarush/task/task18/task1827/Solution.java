package com.javarush.task.task18.task1827;

/* 
Прайсы
*/



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        //C:\\\tmp\\price.txt

        bufferedReader.close();

       if (args.length!=0){
           if (args[0].equals("-c")) {
               addProduct(args[1], Double.parseDouble(args[2]), Integer.parseInt(args[3]), file);
           }
        }
    }

    public static void addProduct(String nameProduct, double price, int quantity, String file) throws IOException {


        BufferedWriter fOut = new BufferedWriter(new FileWriter(file,true));
       int id =getLastLine(file)+1;
       String product = String.format("%-8d%-30s%-8.2f%-4d",id,nameProduct,price,quantity);
       // System.out.println(product);

     fOut.newLine();
      fOut.write(product);
      fOut.close();

    }

    public static int getLastLine (String file) throws IOException{
       ArrayList<Integer> arrayId = new ArrayList<>();
        String line = null;
       String tmp;

       BufferedReader in = new BufferedReader(new FileReader(file));

       while ((tmp = in.readLine())!= null){
           line =tmp;
           arrayId.add(getLastId(line));
       }
        in.close();

        Collections.sort(arrayId);
        return arrayId.get(arrayId.size()-1);
    }

    public static int getLastId(String lastLine){
        String tmp = lastLine.substring(0,8);
        tmp= tmp.trim();
        int id = Integer.parseInt(tmp);

        return id;
    }


}
