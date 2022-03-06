package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V object = cache.get(key);
        if (object == null){

         // create Object with Reflection
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
        object = (V) constructor.newInstance(key);
            cache.put(key, object);
        }
        //TODO add your code here
        return object;
    }

    public boolean put(V obj) {
        try {
        Class typeClass = obj.getClass();
        Method method = typeClass.getDeclaredMethod("getKey", null);
            method.setAccessible(true);
            K key = (K) method.invoke(obj );
            cache.put(key, obj);
            return true;

        } catch (NoSuchMethodException noSuchMethodException) {
            return false;
        } catch (InvocationTargetException invocationTargetException) {
            return false;
        } catch (IllegalAccessException illegalAccessException) {
            return false;
        }
        //TODO add your code here

    }

    public int size() {
        return cache.size();
    }
}
