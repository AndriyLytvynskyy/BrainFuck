package com.study.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * https://www.programcreek.com/2013/02/leetcode-permutations-java/
 *
 * @author andrii_lytvynskyi
 */
public class UniquePermutations {

    public static List<List<Integer>> permutationLeetCode(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());

        for (int i = 0; i < nums.length; i++) {

            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for (List<Integer> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, nums[i]);

                    ArrayList<Integer> temp = new ArrayList<>(l);
                    if (!current.contains(temp)) {
                        current.add(temp);
                    }

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);

        }
        return result;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        java.util.List<java.util.List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            Set<ArrayList<Integer>> current = new HashSet<>();
            for (List<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, nums[i]);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
                    // - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permutationLeetCode(new int[] { 1, 2, 3 }));
    }
}
