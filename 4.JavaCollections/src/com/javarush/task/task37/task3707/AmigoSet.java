package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet(){
        this.map = new HashMap();
    }

    public AmigoSet(Collection< ? extends E> collection){
        int capacity = Math.max(16,(int) Math.ceil(collection.size() /.75f));
        this.map = new HashMap<>(capacity);
        addAll(collection);
    }
    @Override
    public boolean add(E e){
       return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone()  {
        AmigoSet cloneAmigo = null;
        try {
           cloneAmigo  = (AmigoSet) super.clone();
            cloneAmigo.map = (HashMap) map.clone();

        } catch (Exception e) {
         throw  new InternalError(e);
        }
        return cloneAmigo;
    }

    private  void writeObject(ObjectOutputStream obOS){

        try {
           obOS.defaultWriteObject();
           obOS.writeObject(this.map.size());
           obOS.writeObject(HashMapReflectionHelper.callHiddenMethod(this.map, "loadFactor"));
           obOS.writeObject(HashMapReflectionHelper.callHiddenMethod(this.map,"capacity"));
            for (E key: this.map.keySet()) {
                obOS.writeObject(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readObject(ObjectInputStream obIS){
        try {
            obIS.defaultReadObject();
            int size = (int) obIS.readObject();
            float loadFactor = (float) obIS.readObject();
            int capacity = (int) obIS.readObject();
            map = new HashMap<>(capacity,loadFactor);
            for (int i = 0; i < size; i++){
                map.put((E) obIS.readObject(),PRESENT);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
