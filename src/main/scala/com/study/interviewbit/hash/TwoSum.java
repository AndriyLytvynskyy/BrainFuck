package com.study.interviewbit.hash;

import java.util.*;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2.
 Please note that your returned answers (both index1 and index2 ) are not zero-based.
 Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ).
 Note that, if no pair exists, return empty list.

 If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 */

public class TwoSum {
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Set<Integer> set = new HashSet<Integer>(A);
        ArrayList<Integer> result = new ArrayList<>();
        for (int index = 0; index < A.size(); index++) {
            if (set.contains(B - A.get(index))) {
                int index1 = index + 1;
                int index2 = (A.indexOf(B - A.get(index)) + 1);
                if (index1 != index2) {
                    int minIndex = Math.min(index1, index2);
                    int maxIndex = Math.max(index1, index2);
                    if (result.isEmpty()) {
                        result.add(minIndex);
                        result.add(maxIndex);
                    } else {
                        //compare max index
                        if (result.get(1) > maxIndex) {
                            result.remove(1);
                            result.remove(0);
                            result.add(0, minIndex);
                            result.add(1, maxIndex);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Integer[] array = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
        Integer[] array = {1, 1, 1 };
        final List<Integer> list = Arrays.asList(array);
        ArrayList<Integer> ls = twoSum(list, 2);
        for (Integer l : ls) {
            System.out.println(l);
        }
    }
}
