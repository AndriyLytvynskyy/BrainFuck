package com.study.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 * https://www.youtube.com/watch?v=IER1ducXujU
 *
 */
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        combinationRecursive2(results, candidates, combination, target, 0);

        return results;
    }


    private static void combinationRecursive2(List<List<Integer>> results, int[] candidates, List<Integer> combination, int target, int start) {
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            results.add(new ArrayList<>(combination));
        }
        else {
            for (int i = start; i < candidates.length; i++) {

                if (i > start && candidates[i] == candidates[i - 1]) { // remove duplicates
                    continue;
                }

                combination.add(candidates[i]);
                combinationRecursive2(results, candidates, combination, target - candidates[i], i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        String s = "12345";


    }
}
