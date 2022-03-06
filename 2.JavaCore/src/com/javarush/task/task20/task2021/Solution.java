package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

      private void writeObject(ObjectOutputStream os) throws NotSerializableException {
      throw new NotSerializableException();
      }

      private void readObject (ObjectInputStream is) throws NotSerializableException{
          throw new NotSerializableException();
      }



    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
      /*  ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("subSolution.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("subSolution.txt"));


        SubSolution subSolution = new SubSolution();
        ous.writeObject(subSolution);

        SubSolution subSolution1 = new SubSolution();
        subSolution1 = (SubSolution) ois.readObject();

       */


    }
}

