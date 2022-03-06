package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {


    public static void main(String[] args) {
        Solution savedObject = new Solution(4);
        System.out.println(savedObject);
        try{
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("2014.txt"));
            ous.writeObject(savedObject);
            ous.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("2014.txt"));
            Solution loadedObject =(Solution) ois.readObject();
            System.out.println(loadedObject);

        }catch (IOException | ClassNotFoundException o){
            o.getMessage();

        }


    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %d C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
