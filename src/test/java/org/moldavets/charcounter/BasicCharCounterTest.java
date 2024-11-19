package org.moldavets.charcounter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasicCharCounterTest {

    @Test
    void basicCharCounter_shouldReturnEmptyMap_whenInputStringIsEmpty() {
        CharCounter counter = new BasicCharCounter();

        boolean actual = counter.count("").isEmpty();
        assertTrue(actual);
    }

    @Test
    void basicCharCounter_shouldReturnMapWithOneKeyAndOneValue_whenInputStringContainsOneSymbol() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> actual = counter.count("a");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsRepeatingCharacters() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 3);

        Map<Character, Integer> actual = counter.count("aaabbb");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsDifferentCharacters() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);

        Map<Character, Integer> actual = counter.count("abc");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsDifferentCharactersAndSpaces() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);
        expected.put(' ', 3);

        Map<Character, Integer> actual = counter.count("abc   ");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsSameLettersInLowerAndUpperCase() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('A', 1);

        Map<Character, Integer> actual = counter.count("aA");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsNonAlphabeticCharacters() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('@', 1);
        expected.put('#', 1);
        expected.put('!', 1);

        Map<Character, Integer> actual = counter.count("#@!");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsUnicodeCharacters() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('❤', 1);
        expected.put('✔', 1);

        Map<Character, Integer> actual = counter.count("✔❤");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsOnlyFiveSpaces() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put(' ', 5);

        Map<Character, Integer> actual = counter.count("     ");

        assertEquals(expected, actual);
    }

    @Test
    void basicCharCounter_shouldReturnCorrectAnswer_whenInputStringContainsSameCharactersOfDifferentTypes() {
        CharCounter counter = new BasicCharCounter();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('а', 1);

        Map<Character, Integer> actual = counter.count("aа");

        assertEquals(expected, actual);
    }


}