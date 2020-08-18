package com.study.leet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

/**
 * @author andrii_lytvynskyi
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }


        // Number of unique characters in t, which need to be present in the desired window.        if (s.length() == 0 || t.length() == 0) {
        //            return "";
        //        }
        //        // Dictionary which keeps a count of all the unique characters in t.
        //        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        //        for (int i = 0; i < t.length(); i++) {
        //            int count = dictT.getOrDefault(t.charAt(i), 0);
        //            dictT.put(t.charAt(i), count + 1);
        //        }
        //
        //        // Number of unique characters in t, which need to be present in the desired window.
        //        int required = dictT.size();
        //        // Left and Right pointer
        //        int l = 0, r = 0;
        //
        //        // formed is used to keep track of how many unique characters in t
        //        // are present in the current window in its desired frequency.
        //        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        //        // Thus formed would be = 3 when all these conditions are met.
        //        int formed = 0;
        //
        //        // Dictionary which keeps a count of all the unique characters in the current window.
        //        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        //        // ans list of the form (window length, left, right)
        //        int[] ans = {-1, 0, 0};
        //        while (r < s.length()) {
        //            // Add one character from the right to the window
        //            char c = s.charAt(r);
        //            int count = windowCounts.getOrDefault(c, 0);
        //            windowCounts.put(c, count + 1);
        //
        //            // If the frequency of the current character added equals to the
        //            // desired count in t then increment the formed count by 1.
        //            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
        //                formed++;
        //            }
        //
        //            // Try and contract the window till the point where it ceases to be 'desirable'.
        //            while (l <= r && formed == required) {
        //                c = s.charAt(l);
        //                // Save the smallest window until now.
        //                if (ans[0] == -1 || r - l + 1 < ans[0]) {
        //                    ans[0] = r - l + 1;
        //                    ans[1] = l;
        //                    ans[2] = r;
        //                }
        //
        //                // The character at the position pointed by the
        //                // `Left` pointer is no longer a part of the window.
        //                windowCounts.put(c, windowCounts.get(c) - 1);
        //                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
        //                    formed--;
        //                }
        //
        //                // Move the left pointer ahead, this would help to look for a new window.
        //                l++;
        //            }
        //
        //            // Keep expanding the window once we are done contracting.
        //            r++;
        //        }
        //
        //        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        int required = dictT.size();
        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};
        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);


//        List<String> foundWindows = new ArrayList<>();
//        int l = 0;
//        int r = l + 1;
//        Set<Character> charsToFind = stringToCharacterSet(t);
//        while (l < s.length()) {
//            String window = s.substring(l, r);
//            Set<Character> formedWindow = stringToCharacterSet(window);
//
//            if (!formedWindow.containsAll(charsToFind)) {
//                if (r <= s.length() - 1) {
//                    r++;
//                } else {
//                    l++;
//                }
//            } else {
//                foundWindows.add(window);
//                l++;
//            }
//        }
//        java.util.Collections.sort(foundWindows, (o1, o2) -> {
//            if (o1.length() == o2.length()) {
//                return 0;
//            }
//            return o1.length() < o2.length() ? -1 : 1;
//        });
//        return (foundWindows.get(0).length() < t.length() ? "" : foundWindows.get(0));

    }

    private static Set<Character> stringToCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
