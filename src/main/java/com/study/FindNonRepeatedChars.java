package com.study;

import java.util.*;

/**
 * Created by Andrii_Lytvynskyi on 6/17/2015.
 */
public class FindNonRepeatedChars {
    public static char getFirstNonRepChar(String word){
        char[] allChars = word.toCharArray();
        List<Character> nonRepeatable = new ArrayList<Character>();
        Set<Character> repeatable = new HashSet<Character>();
        for (Character ch : allChars) {
            if (repeatable.contains(ch)){
                continue;
            }
            if (nonRepeatable.contains(ch)){
                nonRepeatable.remove(ch);
                repeatable.add(ch);
            } else {
                nonRepeatable.add(ch);
            }
        }
        return nonRepeatable.get(0);
    }

    public static void main(String[] args) {
        System.out.println(getFirstNonRepChar("wwoorrdf"));
    }
}
