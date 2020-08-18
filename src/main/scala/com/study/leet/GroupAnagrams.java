package com.study.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 *
 * Note: review second solution, first solution is simple
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagramsHashMap(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagramsCount(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s1, String s2) {
        char[] word1 = s1.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = s2.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
    //    public static List<List<String>> groupAnagrams(String[] strs) {
    //        Arrays.sort(strs);
    //        System.out.println(binarySearch(strs, strs.length, "tea"));
    //        List<List<String>> result = new ArrayList<>();
    //        ListIterator<String> iter = Arrays.asList(strs).listIterator();
    //        while (iter.hasNext()){
    //            String str = iter.next();
    //            List<String> group = new ArrayList<>();
    //            group.add(str);
    //            while ("".equalsIgnoreCase(binarySearch(strs, strs.length, str))
    //            if ("".equalsIgnoreCase(binarySearch(strs, strs.length, str)){
    //
    //            }
    //
    //
    //        }
    //        //        for (String str : strs) {
    //        //            result.add(binarySearch(strs, strs.length, str));
    //
    //        //        }
    //        return result;
    //    }

    public static String binarySearch(String[] strs, int n, String key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!isAnagram(strs[mid], key) && key.compareTo(strs[mid]) < 0) {
                high = mid - 1;
            } else if (!isAnagram(strs[mid], key) && key.compareTo(strs[mid]) > 0) {
                low = mid + 1;
            } else {
                return strs[mid];
            }
        }
        return "";
    }

}
