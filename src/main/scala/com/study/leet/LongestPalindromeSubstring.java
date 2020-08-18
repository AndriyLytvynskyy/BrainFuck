package com.study.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=b4vgaENSRrY
 * @author andrii_lytvynskyi
 */
public class LongestPalindromeSubstring {

//    private static Set<String> palindromesCache = new HashSet();
//
//    public static String longestPalindrome(String s) {
//        String longest = "";
//        Set<String> palindromesCache = new HashSet();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length() + 1; j++) {
//                String substring = s.substring(i, j);
//
//                if (isPalindr(substring, palindromesCache)) {
//                    palindromesCache.add(substring);
//                    if (longest.length() < (j - i)) {
//                        longest = substring;
//                    }
//                }
//
//            }
//
//        }
//        return longest;
//    }
//
//    private static boolean isPalindr(String s, Set<String> known) {
//
//        if (s.length() == 1 || s.isEmpty())
//            return true;
//        if (s.charAt(0) == s.charAt(s.length() - 1)) {
//            String substring = s.substring(1, s.length() - 1);
//            if (!known.contains(substring)) {
//               return isPalindr(substring, known);
//
//            } else {
//                return true;
//
//            }
//
//        }
//        return false;
//    }

    private static int lo, maxLen;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
           // extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int leftDirection, int rightDirection) {
        while (leftDirection >= 0 && rightDirection < s.length() && s.charAt(leftDirection) == s.charAt(rightDirection)) {
            leftDirection--;
            rightDirection++;
        }
        if (maxLen < rightDirection - leftDirection - 1) {
            lo = leftDirection + 1;
            maxLen = rightDirection - leftDirection - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }
}
