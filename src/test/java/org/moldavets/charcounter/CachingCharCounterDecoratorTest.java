package org.moldavets.charcounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.moldavets.cache.Cache;

import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CachingCharCounterDecoratorTest {

    @Mock
    private Cache<String, Map<Character, Integer>> cache;
    @Mock
    private CharCounter charCounter;
    @InjectMocks
    private CachingCharCounterDecorator cachingCharCounterDecorator;


    @Test
    void cachingCharCounterDecorator_shouldReturnCachedValue_whenInputAlreadyInCache() {

        String input = "hello";

        Map<Character, Integer> cachedResult = new HashMap<>();
        cachedResult.put('h', 1);
        cachedResult.put('e', 1);
        cachedResult.put('l', 2);
        cachedResult.put('o', 1);

        when(cache.containsKey(input)).thenReturn(true);
        when(cache.get(input)).thenReturn(cachedResult);

        Map<Character, Integer> result = cachingCharCounterDecorator.count(input);

        assertEquals(cachedResult, result);

        verify(charCounter, never()).count(input);

    }

    @Test
    void cachingCharCounterDecorator_shouldReturnNotCachedValue_whenInputNotInCache() {

        String input = "hello";

        Map<Character, Integer> countedResult = new HashMap<>();
        countedResult.put('h', 1);
        countedResult.put('e', 1);
        countedResult.put('l', 2);
        countedResult.put('o', 1);

        when(cache.containsKey(input)).thenReturn(false);
        when(charCounter.count(input)).thenReturn(countedResult);
        when(cache.get(input)).thenReturn(countedResult);

        Map<Character, Integer> result = cachingCharCounterDecorator.count(input);

        assertEquals(countedResult, result);

        verify(charCounter).count(input);
        verify(cache).put(input, countedResult);
    }

    @Test
    void cachingCharCounterDecorator_shouldThrowExeption_whenInputContainsNull() {

        String input = null;

        assertThrows(NullPointerException.class,
                () -> cachingCharCounterDecorator.count(input));

        verify(charCounter, never()).count(input);

        verify(cache, never()).get(input);
        verify(cache, never()).put(null,null);
    }

    @Test
    void cachingCharCounterDecorator_shouldReturnNotCachedValue_whenInputContainsNothing() {

        String input = "";

        Map<Character, Integer> countedResult = new HashMap<>();

        when(cache.containsKey(input)).thenReturn(false);
        when(charCounter.count(input)).thenReturn(countedResult);
        when(cache.get(input)).thenReturn(countedResult);

        Map<Character, Integer> result = cachingCharCounterDecorator.count(input);

        assertEquals(countedResult, result);

        verify(charCounter).count(input);
        verify(cache).put(input, countedResult);
    }


}