package com.booking.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p/>
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 * <p/>
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 * <p/>
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 * <p/>
 * Example:
 * <p/>
 * Given the array as:
 * <p/>
 * [
 * <p/>
 * "abcdefgh",
 * <p/>
 * "aefghijk",
 * <p/>
 * "abcefgh"
 * ]
 * The answer would be “a”.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(ArrayList<String> a) {
        String firstString = a.get(0);
        StringBuilder longestPrefix = new StringBuilder();
        for (int i = 0; i < firstString.toCharArray().length; i++) {
            longestPrefix.append(firstString.charAt(i));
            for (int j = 1; j < a.size(); j++) {
                if (!a.get(j).startsWith(longestPrefix.toString())) {
                    longestPrefix.deleteCharAt(i);
                    return longestPrefix.toString();
                }
            }
        }
        return longestPrefix.toString();
    }

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("abcd", "abde", "abcf");
        ArrayList<String> arrayList = new ArrayList<>(ls);
        System.out.println(longestCommonPrefix(arrayList));

    }
}
