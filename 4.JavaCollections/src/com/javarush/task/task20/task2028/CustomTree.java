package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public  class CustomTree extends AbstractList<String>  implements Cloneable, Serializable {
    List<Entry> customList = new ArrayList<>();
    Entry<String> root;



    public CustomTree(){
        this.root = new Entry<>("0");
        this.customList.add(root);

    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String set(int index, String element) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String elementName){
        Queue<Entry> entryQueue = new LinkedList<>();
        Entry<String> dad = root;
        entryQueue.add(dad);
        Entry<String> entryAdded = new Entry<>(elementName);
        do{
        if (dad.isAvailableToAddChildren()){
            if (dad.availableToAddLeftChildren){
                dad.leftChild = entryAdded;
                dad.availableToAddLeftChildren = false;
                entryAdded.parent = dad;
                entryQueue.offer(entryAdded);
            }
            else if (dad.availableToAddRightChildren){
               dad.rightChild = new Entry<>(elementName);
               dad.availableToAddRightChildren = false;
               dad.rightChild.parent = dad;
               entryAdded.parent = dad;
               entryQueue.offer(entryAdded);
            }

        }

    }while (!entryQueue.isEmpty());


       return false;
    }




    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public String getParent( String elementName){

        if (elementName ==root.parent.elementName);

      ////??????
        return elementName;
    }

    static class Entry< T > implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry <T> parent;
        Entry <T> leftChild;
        Entry <T> rightChild;

        public Entry (String elementName){
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }


}
