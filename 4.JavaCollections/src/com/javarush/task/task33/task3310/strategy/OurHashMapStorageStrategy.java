package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy  implements StorageStrategy{
   private static final int DEFAULT_INITIAL_CAPACITY = 16;
   private static final float DEFAULT_LOAD_FACTOR = 0.75f;
   private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
   private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

     public int hash(Long k){
         /*
         static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
          */
         int h;
         return (k == 0L) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
     }

    public  int indexFor(int hash, int length){
       return hash & (length - 1);
    }

    public Entry getEntry(Long key){

         int hash = (key == null) ? 0 : hash( (long) key.hashCode());
            for (Entry e = table[indexFor(hash, table.length)];
                 e != null;
                 e = e.next) {
               Object k;
                if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            }
            return null;

    }

    public void resize(int newCapacity){
         Entry[] oldTable = table; //При инициализации таблица равна нулю
        // Сохраняем емкость таблицы
            int oldCapacity = oldTable.length;
      //  Когда текущая емкость таблицы больше, чем максимальное значение емкости, потому что вы хотите
      //  поместить элементы в карту, вам нужно установить порог на максимальное значение integer.MAX_VALUE и
      //  напрямую вернуть адрес oldTab (эта емкость сделает емкость существующей таблицы
      //  <threshold = capacity * loadFactor> станет больше, вы можете продолжать хранить элементы)
            if (oldCapacity == 1 << 30) {//MAXIMUM_CAPACITY = 1 << 30;
                threshold = Integer.MAX_VALUE;
                return;
            }
            Entry[] newTable = new Entry[newCapacity];
            transfer(newTable);
            table = newTable;
            threshold = (int)(newCapacity * loadFactor);      
     }

    public void transfer(Entry[] newTable){
            Entry[] src = table;
            int newCapacity = newTable.length;
            for (int j = 0; j < src.length; j++) {
                Entry e = src[j];
                if (e != null) {
                    src[j] = null;
                    do {
                        Entry next = e.next;
                        int i = indexFor(e.hash, newCapacity);
                        e.next = newTable[i];
                        newTable[i] = e;
                        e = next;
                    } while (e != null);
                }
            }
    }
       
    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (table[bucketIndex] == null) {
            createEntry(hash, key, value, bucketIndex);
        } else {
            Entry e = table[bucketIndex];
            table[bucketIndex] = new Entry(hash, key, value, e);
            if (size++ >= threshold)
                resize(2 * table.length);

        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
         table[bucketIndex] = new Entry(hash, key, value, null);
         size++;
    }

    @Override
    public boolean containsKey(Long key) {

        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {

         Entry[] tab = table;
        for (Entry entry : tab) {
            for (Entry e = entry; e != null; e = e.next) {
                if (value.equals(e.value))
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
         int hash = (key == null) ? 0 : hash((long) key.hashCode());
         int bucketIndex  = indexFor(hash, table.length);

        // проверяем, есть ли такой элемент в таблице
         for (Entry e = table[bucketIndex]; e != null; e = e.next){
             Object k;
             if (e.hash == hash &&
                     ((k = e.key) == key || (key != null && key.equals(k)))){
                 e.value = value;
                 return;
             }
         }
       addEntry(hash,key,value,bucketIndex);
    }

    @Override
    public Long getKey(String value) {
         if (value != null) {
             for (int i = 0; i < table.length; i++) {
                 for (Entry e = table[i]; e != null; e = e.next) {
                     if (value.equals(e.getValue())) {
                         return e.getKey();
                     }
                 }
             }
         }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key != null) {
            for (int i = 0; i < table.length; i++){
                for (Entry e = table[i]; e != null; e = e.next){
                    if (key.equals(e.key)) {
                        return e.getValue();
                    }
                }
            }
        }
        return null;
    }
}
