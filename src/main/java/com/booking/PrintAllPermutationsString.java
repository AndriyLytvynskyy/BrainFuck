package com.booking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Print all permutation of String both iterative and Recursive way
 * ab -> ab, ba
 * <p/>
 * abc -> abc, bac
 */
public class PrintAllPermutationsString {

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


    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("ABC".substring(1));
        List<String> perms = permutationList("AB");
        for (String perm : perms) {
            System.out.println(perm);
        }
    }

}
