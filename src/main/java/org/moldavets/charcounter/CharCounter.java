package org.moldavets.charcounter;

import java.util.Map;

public interface CharCounter {
    Map<Character, Integer> count(String input);
}
