package com.javarush.task.task33.task3310.strategy;


import java.io.File;

public class FileStorageStrategy implements StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long bucketSizeLimit= DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public long getBuketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBuketSizeLimit(long buketSizeLimit) {
        this.bucketSizeLimit = buketSizeLimit;
    }

    public int hash(Long k){
        int h;
        return (k == 0L) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public  int indexFor(int hash, int length){
        return hash & (length - 1);
    }

    public Entry getEntry(Long key){

        int hash = (key == null) ? 0 : hash( (long) key.hashCode());

        for (Entry e =  table[indexFor(hash, table.length)].getEntry(); e != null; e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;

    }

    public void resize(int newCapacity){
        FileBucket [] newTable = new FileBucket [newCapacity];
        transfer(newTable);
        table = newTable;
       
    }

    public void transfer(FileBucket[] newTable){
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (FileBucket bucket : src) {
            Entry e = bucket.getEntry();
            while (e != null){
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (table[bucketIndex] == null) {
            createEntry(hash, key, value, bucketIndex);
        } else {
            Entry e = table[bucketIndex].getEntry();
            FileBucket fileBucket = table[bucketIndex];
           fileBucket.putEntry(new Entry(hash, key, value, e));
            size++;
            if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
                resize(2 * table.length);
            }
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        FileBucket fileBucket = new FileBucket();
        table[bucketIndex] = fileBucket;
        fileBucket.putEntry(new Entry(hash, key, value, null));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {

        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {

            FileBucket[] tab = table;
            for (FileBucket fb : tab) {
                if (fb != null) {
                    for (Entry e = fb.getEntry(); e != null; e = e.next) {
                        if (value.equals(e.value))
                            return true;
                    }
                }

            }

        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        int bucketIndex  = indexFor(hash, table.length);

        // проверяем, есть ли такой элемент в таблице
        FileBucket fileBucket = table[bucketIndex];
        if (fileBucket != null) {
            for (Entry e = fileBucket.getEntry(); e != null; e = e.next) {
                Object k;
                if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k)))) {
                    e.value = value;
                    return;
                }
            }
        }
        addEntry(hash,key,value,bucketIndex);
    }

    @Override
    public Long getKey(String value) {
        if (value != null) {
            for (FileBucket fileBucket : table) {
                if (fileBucket != null) {
                    for (Entry e = fileBucket.getEntry(); e != null; e = e.next) {
                        if (value.equals(e.getValue())) {
                            return e.getKey();
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key != null) {
            for (FileBucket fileBucket : table){
                if (fileBucket != null) {
                    for (Entry e = fileBucket.getEntry(); e != null; e = e.next) {
                        if (key.equals(e.key)) {
                            return e.getValue();
                        }
                    }
                }
            }
        }
        return null;
    }
}
