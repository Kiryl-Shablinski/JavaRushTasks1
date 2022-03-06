package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V obj = null;
       if (!containsKey(key)) {
          List<V> list = new ArrayList<>();
          list.add(value);
           map.put(key, list);
           return null;
       }
           List<V> lists = map.get(key);
       if (!lists.isEmpty()) {

           if (lists.size() < repeatCount) {
               obj = lists.get(lists.size() -1);
               lists.add(value);


           } else if (lists.size() == repeatCount) {
               lists.remove(0);
               obj = lists.get(lists.size() - 1);
               lists.add(value);
           }
       }
        return obj;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        V obj = null;
        if (!map.containsKey(key)) return null;
        List<V> collect = map.get(key);
        obj = collect.get(0);
        collect.remove(0);

        if (collect.isEmpty()){
            map.remove(key,collect);
        }
        return obj;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> lists = new ArrayList<>();
        for (List<V> list: map.values()) {
            lists.addAll(list);
        }
        return lists;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        Collection<V> collect = values();
        for (V obj : collect){
            if (obj.equals(value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}