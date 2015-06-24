package com.booking.strings;

/**
 * 1.3
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class StringPermutationOfAnother {
    public String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }
}
