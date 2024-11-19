package org.moldavets.cache;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache<K,V> implements Cache<K,V> {

    private final Map<K,V> cacheMap = new HashMap<>();

    @Override
    public void put(K key, V value) {
        cacheMap.put(key,value);
    }

    @Override
    public V get(K key) {
        return cacheMap.get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return cacheMap.containsKey(key);
    }


}
