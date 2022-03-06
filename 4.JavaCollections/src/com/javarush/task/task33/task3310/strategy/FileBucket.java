package com.javarush.task.task33.task3310.strategy;


import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileBucket {

    private Path path;

    public FileBucket(){
        try {
            path = Files.createTempFile(null, null);
           Files.deleteIfExists(path);
            Files.createFile(path);

        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();

    }

    public void putEntry(Entry entry){

       try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))){

           out.writeObject(entry);

       }catch (IOException o){
               ExceptionHandler.log(o);

        }

    }

    public Entry getEntry(){
        Entry entry = null;

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){
            if (getFileSize() == 0){
                return null;
            }

            entry = (Entry) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
           ExceptionHandler.log(e);
        }
        return entry;
    }

    public long getFileSize()  {

        long size = 0;

      try{
          size = Files.size(path);
          return size;
      }catch (IOException e){
        ExceptionHandler.log(e);
      }
       return size;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
           ExceptionHandler.log(e);
        }
    }


}
