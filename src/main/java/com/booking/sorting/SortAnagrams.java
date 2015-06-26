package com.booking.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each
 * other.
 */
public class SortAnagrams {

    class AnagramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public void sort(String[] array) {
        Hashtable<String, LinkedList<String>> hash =
                new Hashtable<String, LinkedList<String>>();
            /* Group words by anagram */
        for (String s : array) {
            String key = new AnagramComparator().sortChars(s);
            if (!hash.containsKey(key)) {
                hash.put(key, new LinkedList<String>());
            }
            LinkedList<String> anagrams = hash.get(key);
            anagrams.push(s);
        }

             /* Convert hash table to array */
        int index = 0;
        for (String key : hash.keySet()) {
            LinkedList<String> list = hash.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }
}

