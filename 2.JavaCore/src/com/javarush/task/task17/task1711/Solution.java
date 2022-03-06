package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        switch (args[0]){

            case "-c":
                synchronized (allPeople) {
                    for (int i=1;i<args.length;i+=3) {

                        addPerson(args[i], args[i+1], args[i+2]);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                //  System.out.print(allPeople.get(2).getName()+" "+allPeople.get(2).getSex()+" "+allPeople.get(2).getBirthDate());
                break;


            case "-u":
                synchronized (allPeople) {
                    for (int i=1;i<args.length;i+=4) {
                        upgraidPerson(Integer.parseInt(args[i]), args[i+1], args[i+2], args[i+3]);
                    }
                }
                break;


            case "-d":
                synchronized (allPeople) {
                    for (int i=1;i<args.length;i++) {
                        removPerson(Integer.parseInt(args[i]));
                    }
                }
            break;


            case "-i":
                synchronized (allPeople) {
                    for (int i=1; i <args.length ; i++) {
                        printPerson(Integer.parseInt(args[i]));
                    }
                }

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
        allPeople.set(id, Person.createMale(null,null));
        allPeople.get(id).setSex(null);
    }

    public static void printPerson(int id){
        SimpleDateFormat outputFofmat=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String sex=allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж";


        System.out.println(allPeople.get(id).getName() + " " + sex +" "+outputFofmat.format(allPeople.get(id).getBirthDate()));
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
