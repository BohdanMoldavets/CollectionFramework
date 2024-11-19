package org.moldavets.charcounter;

import java.util.HashMap;
import java.util.Map;

public class BasicCharCounter implements CharCounter {

    @Override
    public Map<Character, Integer> count(String input) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        for(int i = 0; i < input.length(); i++) {
            int value = charCountMap.getOrDefault(input.charAt(i), 0);
            charCountMap.put(input.charAt(i), value+1);
        }
        return charCountMap;
    }

}
