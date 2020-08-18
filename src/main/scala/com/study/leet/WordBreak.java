package com.study.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author andrii_lytvynskyi
 */
public class WordBreak {
    public static boolean wordBreakTimeLimit(String s, List<String> wordDict) {
            String s1 = "";
            Arrays.sort(s1.toCharArray());
           return wordBreakHelper(s, new HashSet<String>(wordDict), 0);
    }

    private static boolean wordBreakHelper(String s, Set<String> wordDict, int start){
        if (start == s.length()) return true;
        for (int end = start + 1; end <= s.length(); end ++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakHelper(s, wordDict, end)){
                return true;
            }
        }
        return false;
    }

//    public static boolean wordBreak(String s, List<String> wordDict) {
//
//        return wordBreakHelper(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
//    }
//
//    private static boolean wordBreakHelper(String s, Set<String> wordDict, int start, Boolean[] memo){
//        if (start == s.length()) return true;
//        if (memo[start] != null){
//            return memo[start];
//        }
//        for (int end = start + 1; end <= s.length(); end ++) {
//            String substring = s.substring(start, end);
//            System.out.println(substring);
//            if (wordDict.contains(substring) && wordBreakHelper(s, wordDict, end, memo)){
//                return memo[start] = true;
//            }
//        }
//        return memo[start] = false;
//    }

    public static void main(String[] args) {
        System.out.println(wordBreakTimeLimit("aaaab", Arrays.asList("a", "aa", "aaa")));
    }
}
