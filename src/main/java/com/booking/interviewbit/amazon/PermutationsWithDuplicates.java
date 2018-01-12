package com.booking.interviewbit.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Basic idea is to permutate with Hash Tables
 *
 *
 */
public class PermutationsWithDuplicates {

    Map<Character, Integer> buildFreqMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                Integer value = freqMap.get(ch);
                freqMap.put(ch, ++value);
            } else {
                freqMap.put(ch, 0);
            }
        }
        return freqMap;
    }


    public void printPerms(String s) {
        Map<Character, Integer> map = buildFreqMap(s);

    }

    public void printPerms(int remaining, String prefix, Map<Character, Integer> freqMap) {
        Set<Character> keySet = freqMap.keySet();

        for (Character character : keySet) {
            int count = freqMap.get(character);
            freqMap.put(character, count - 1);
            printPerms(0, "", freqMap);
            freqMap.put(character, count);
        }
    }

}
