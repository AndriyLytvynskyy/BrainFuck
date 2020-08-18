package com.study.interviewbit.amazon.leet.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author andrii_lytvynskyi
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banset = new HashSet();
        banset.addAll(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;
        String paragrahReplaced = paragraph;
        String notAllowedChars = "!?',;.";
        for (char notAllowed: notAllowedChars.toCharArray()){
            paragrahReplaced = paragrahReplaced.replace(notAllowed, ' ');
        }
       // String paragraphReplaced = paragrahReplaced.replaceAll("[^a-zA-Z]", " ");
        String[] words = paragrahReplaced.split("\\s");
        for (String word : words) {
            if (!word.isEmpty()) {
                String cleanedWord = word.toLowerCase();
                if (!banset.contains(cleanedWord)) {
                    count.put(cleanedWord, count.getOrDefault(cleanedWord, 0) + 1);
                    if (count.get(cleanedWord) > ansfreq) {
                        ansfreq = count.get(cleanedWord);
                        ans = cleanedWord;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       // mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" });
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[] { "bob", "hit" }));

    }

}