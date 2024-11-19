package org.moldavets.charcounter;

import org.moldavets.cache.Cache;

import java.util.Map;

public class CachingCharCounterDecorator implements CharCounter {

    private final Cache<String, Map<Character, Integer>> cache;
    private final CharCounter charCounter;

    public CachingCharCounterDecorator(Cache<String, Map<Character, Integer>> cache, CharCounter charCounter) {
        this.cache = cache;
        this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> count(String input) {

        if (input == null) {
            throw new NullPointerException();
        }

        if(cache.containsKey(input)){
            return cache.get(input);
        } else {
            cache.put(input, charCounter.count(input));
            return cache.get(input);
        }
    }


}
