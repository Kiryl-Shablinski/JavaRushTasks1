package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{

   private OriginalRetriever originalRetriever;
   private LRUCache lruCache = new LRUCache(20) ;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
       Object  objectCache = lruCache.find(id);

       if (objectCache == null){
           objectCache = originalRetriever.retrieve(id);
           lruCache.set(id,objectCache);
       }
        return objectCache;
    }
}
