package com.booking.interviewbit.amazon;

import java.util.*;

/**
 * Basic idea is to permutate with Hash Tables
 *
 *
 */
public class PermutationsWithDuplicates {

    static Map<Character, Integer> buildFreqMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                Integer value = freqMap.get(ch);
                freqMap.put(ch, ++value);
            } else {
                freqMap.put(ch, 1);
            }
        }
        return freqMap;
    }


    public static void printPerms(String s) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = buildFreqMap(s);
        printPerms(map, "", s.length(), result);
    }

    public static void printPerms( Map<Character, Integer> freqMap, String prefix, int remaining, List<String> result) {
        if (remaining ==0){
            result.add(prefix);
            return;
        }
        Set<Character> keySet = freqMap.keySet();
        for (Character character : keySet) {
            int count = freqMap.get(character);
            if(count>0) {
                freqMap.put(character, count - 1);
                printPerms(freqMap, prefix + character, remaining - 1, result);
                freqMap.put(character, count);
            }
        }

    }

    public static void main(String[] args) {
        //printPerms("ABC");
        printPerms("AB");
    }

}
