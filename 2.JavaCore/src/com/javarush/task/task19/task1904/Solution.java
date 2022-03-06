package com.javarush.task.task19.task1904;



import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {



    public static void main(String[] args) throws IOException{
      /* PersonScannerAdapter personScannerAd = new PersonScannerAdapter(new Scanner(new File("C:\\tmp\\Adapter.txt")));

        personScannerAd.read();
        System.out.println(personScannerAd.toString());
        personScannerAd.close();

       */



    }

    public static class PersonScannerAdapter  implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter (Scanner fileScanner){

            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String firstName = null;
            String middleName = null;
            String lastName = null;
            Date birthDate = null;

            String[] line = fileScanner.nextLine().split(" ",4);

                lastName = line[0];
                firstName = line[1];
                middleName = line[2];

             SimpleDateFormat dateFormat = new SimpleDateFormat();
             dateFormat.applyPattern("dd MM yyyy");

             //int day = Integer.parseInt(line[3]);
             //int mondey = Integer.parseInt(line[4])-1;
            // int yahre = Integer.parseInt(line[5]);

             try {
                // String date =day+" " + mondey+" "+line[5];
                 birthDate = dateFormat.parse(line[3]);
             }catch (ParseException o){
                 o.getMessage();
             }

          //  System.out.println(lastName +" "+ firstName +" " + middleName +" " + birthDate.toString());


            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }

        public int rnd(int max){

            return (int)Math.random() * max;
        }

    }
}
