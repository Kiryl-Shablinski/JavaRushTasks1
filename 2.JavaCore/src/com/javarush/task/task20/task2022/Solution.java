package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
  transient   private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public Solution(){}

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();


    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
       //in.close();
       this.stream= new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution solution = new Solution("Переопределение сериализации в потоке.txt");
        solution.writeObject("Hello Kiryl");

        ObjectOutputStream ous = new ObjectOutputStream(
                new FileOutputStream("Переопределение сериализации в потоке1.txt"));
        ous.writeObject(solution);

        Solution loadSolution = new Solution();
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("Переопределение сериализации в потоке1.txt"));
        loadSolution =(Solution) ois.readObject();
        loadSolution.writeObject("Hello!!!");





    }
}
