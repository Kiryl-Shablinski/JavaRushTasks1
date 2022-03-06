package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }



    public static void main(String[] args) {
        //start here - начни тут
     switch (args[0]){

         case "-c": {addPerson(args[1],args[2],args[3]);
             System.out.println(allPeople.size()-1);
           //  System.out.print(allPeople.get(2).getName()+" "+allPeople.get(2).getSex()+" "+allPeople.get(2).getBirthDate());
         break;
         }

         case "-u": upgraidPerson(Integer.parseInt(args[1]), args[2], args[3], args[4]);
         break;

         case "-d": removPerson(Integer.parseInt(args[1]));
         break;

         case "-i": printPerson(Integer.parseInt(args[1]));
         break;
     }




    }

    public static void addPerson(String name, String sex, String dr){

       if (sexСompare(sex)==true){
           allPeople.add(Person.createMale(name,stringDate(dr)));

       }
       if (sexСompare(sex)==false){

           allPeople.add(Person.createFemale(name, stringDate(dr)));
       }
    }

    public static void upgraidPerson(int id, String name, String sex, String dr){

        if (sexСompare(sex)==true) {
            allPeople.set(id, Person.createMale(name, stringDate(dr)));
        } else {
            allPeople.set(id, Person.createFemale(name, stringDate(dr)));
        }
    }

    public static void removPerson(int id){
       allPeople.set(id,Person.createMale(null,null));
       allPeople.get(id).setSex(null);
    }

    public static void printPerson(int id){
        SimpleDateFormat outputFofmat=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String sex=allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж";


        System.out.print(allPeople.get(id).getName() + " " + sex +" "+outputFofmat.format(allPeople.get(id).getBirthDate()));
    }

    public static Date stringDate(String date) {

        Date date1=null;
        SimpleDateFormat inputFormat=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFofmat=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            try {

                date1=outputFofmat.parse(outputFofmat.format(inputFormat.parse(date)));

            }catch (ParseException o){
                o.printStackTrace();
            }

        return date1;
    }
    public static boolean sexСompare(String sex){
        if (sex.equals("м")) return true;

        if (sex.equals("ж")) return false;

       return false;
    }


}
