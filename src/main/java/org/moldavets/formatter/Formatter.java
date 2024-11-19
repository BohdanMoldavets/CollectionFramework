package org.moldavets.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Formatter {

    static public String format(Map<Character, Integer> charCountMap, String inputString) {

        final String NEW_LINE = "\n";

        StringBuilder resultString = new StringBuilder();
        List<Character> charCountMapResult = new ArrayList<>();

        for(int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            if(!charCountMapResult.contains(character)) {
                resultString.append(String.format("\"%c\" - %s%n", character,charCountMap.get(character),NEW_LINE));
                charCountMapResult.add(character);
            }
        }
        return resultString.toString();
    }


}
