package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;


public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
    }

    @Override
    public int hashCode() {
       if (getKey() == 0L  && getValue() == null)
           return 0;

       int result = 1;
       result = 31 * result + (getKey() == 0L ? 0 : getKey().hashCode());
       result = 31 * result + (getValue() == null ? 0 : getValue().hashCode());

       return result;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
