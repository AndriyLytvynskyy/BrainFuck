package com.booking.interviewbit.hash;

import java.util.*;

/**
 *
 * Given an array of strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index in the original list.
 * Look at the sample case for clarification.
 */

public class Anagram {

    public static List<String> permutationList(String word) {
        List<String> permutations = new ArrayList<String>();
        if (word.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char ch = word.charAt(0);
        String substring = word.substring(1);
        List<String> allwords = permutationList(substring);
        for (String allword : allwords) {
            for (int j = 0; j <= allword.length(); j++) {
                String first = allword.substring(0, j);
                String second = allword.substring(j);
                permutations.add(first + ch + second);
            }
        }
        return permutations;
    }

    public static  List<String> permutationList1(String word){
        List<String> permutations = new ArrayList<String>();
        permutations.add("");
        for (Character ch : word.toCharArray()) {
            List<String> current = new ArrayList<String>();
            for (String allword: permutations) {
                for (int j = 0; j <= allword.length(); j++) {
                    String first = allword.substring(0, j);
                    String second = allword.substring(j);
                    current.add(first + ch + second);
                }
            }
            permutations = new ArrayList<>(current);
        }
        return permutations;
    }

    public static boolean isAnagram(String firstWord, String secondWord) {
        char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Set<String> processedAnagrams = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int firstWordIndex = 0; firstWordIndex< A.size(); firstWordIndex++) {
            String word = A.get(firstWordIndex);
            if (!processedAnagrams.contains(word)) {
                ArrayList<Integer> tempSet = new ArrayList<>();
                tempSet.add(firstWordIndex + 1);
                for (int nextWordIndex = firstWordIndex + 1; nextWordIndex < A.size(); nextWordIndex++){
                   String nextWord = A.get(nextWordIndex);
                   if (isAnagram(word, nextWord)){
                       tempSet.add(nextWordIndex + 1);
                       processedAnagrams.add(word);
                       processedAnagrams.add(nextWord);
                   }
                }

                result.add(tempSet);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        List<String> A = Arrays.asList("cat", "dog", "god", "tca");
       // List<String> A = Arrays.asList( "abcd", "dcba", "dcba", "abcd", "abcd", "adbc", "dabc", "adcb");
//        List<String> A = Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
//                "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa");
//                "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
//                "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
//                "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
//                "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
//                "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
//                "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb");
        ArrayList<ArrayList<Integer>> result = anagrams(A);
        System.out.println(result);
    }
}
