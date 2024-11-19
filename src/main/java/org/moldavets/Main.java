package org.moldavets;

import org.moldavets.cache.Cache;
import org.moldavets.cache.MemoryCache;
import org.moldavets.charcounter.BasicCharCounter;
import org.moldavets.charcounter.CachingCharCounterDecorator;
import org.moldavets.charcounter.CharCounter;
import org.moldavets.formatter.Formatter;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CharCounter counter = new BasicCharCounter();
        Cache<String, Map<Character, Integer>> cache = new MemoryCache<>();
        CharCounter decorator = new CachingCharCounterDecorator(cache, counter);

        String input = "hello world!";
        Map<Character,Integer> result = decorator.count(input);
        String output = Formatter.format(result,input);
        System.out.println(output);

    }
}