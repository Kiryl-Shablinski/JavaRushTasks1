package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/



import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        bufferedReader.close();
        //C:\\tmp\\price.txt

        ArrayList<String> arrayList = new ArrayList<>();

        if (args.length!=0){
            addList(arrayList,file);
          if (args[0].equals("-u")){
              setInfo(args[1],arrayList ,args[2], args[3], args[4], file);
          }
          if (args[0].equals("-d")){
              removeInfo(args[1], arrayList, file);
          }
        }
    }

    public static void addList(ArrayList<String> list, String file) throws IOException{

        BufferedReader fIn =new BufferedReader(new FileReader(file));
        String read;

        while ((read =fIn.readLine())!=null){
            list.add(read);
        }
        fIn.close();

    }

    public static void removeInfo(String id, ArrayList<String> list, String file) throws IOException{

       boolean writer= false;
        BufferedWriter fOut = new BufferedWriter(new FileWriter(file, writer));

        for (int i=0; i<list.size();i++){
            if (stringLine(list.get(i)).equals(id)){
                list.remove(i);
                i--;
            }
            else{
                fOut.write(list.get(i));
                writer= true;
                fOut.newLine();
            }
        }
        fOut.close();

    }
    public static String stringLine(String line){
        String tmp = line.substring(0,8);
        return line = tmp.trim();
    }

    public static void setInfo(String id, ArrayList<String> list, String nameProduct, String price, String quantity, String file) throws IOException{

        boolean writer= false;
        BufferedWriter fOut = new BufferedWriter(new FileWriter(file, writer));

        for (int i=0; i<list.size();i++){
            if (stringLine(list.get(i)).equals(id)){
                String product = String.format("%-8s%-30s%-8.2f%-4s",id,nameProduct,Double.parseDouble(price),quantity);
                list.set(i,product);
               fOut.write(list.get(i));
                writer= true;
                fOut.newLine();
            }
            else{
               fOut.write(list.get(i));
                writer= true;
                fOut.newLine();
            }
        }
        fOut.close();

    }
}
