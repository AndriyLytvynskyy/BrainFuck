package com.booking.interviewbit.hash;

import java.util.*;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 *
 * Input:  {1 ,2 ,-2 ,4 ,-4}
   Output: {2 ,-2 ,4 ,-4}

 KADANE ALGORITHM
 https://en.wikipedia.org/wiki/Maximum_subarray_problem

 Integer[] a = {1, 2, -3, 3 };
 */
public class LargestContinuousSum {
    public static ArrayList<Integer> lszeroSum(List<Integer> A) {
        ArrayList<Integer> results = new ArrayList<>();
        Map<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int sum = 0;
        int max_len = 0;
        int start_pos = 0;
        if (A.size() == 1) {
            results.add(A.get(0));
            return results;
        }
        for (int i = 0; i < A.size(); i++){
            // Add current element to sum
            sum += A.get(i);

            if (sum == 0) {
                max_len = i;
            } else {
                // Look this sum in hash table
                Integer prev_i = hM.get(sum);

                // If this sum is seen before, then update max_len
                if (prev_i != null) {
                    max_len = Math.max(max_len, i - prev_i);
                    if (prev_i !=0 ){
                        start_pos = prev_i - 1;
                    } else {
                        start_pos= prev_i + 1;
                    }

                } else { // Else put this sum in hash table
                    hM.put(sum, i);
                }
            }
        }
        if (start_pos != max_len) {
            for (int i = start_pos; i <= max_len; i++) {
                results.add(A.get(i));
            }
        }
        return results;

    }

    public static Integer lszero(List<Integer> A) {
        ArrayList<Integer> results = new ArrayList<>();
        int size = A.size();
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++){

            max_ending_here = max_ending_here + A.get(i);
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;

    }

    public static void main(String[] args) {

        //Integer[] a = {0};
        //Integer[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        //Integer[] a = {1 ,2 ,-2 ,4 ,-4};
        //Integer[] a = {15, -2, 2, -8, 1, 7, 10, 23};
        Integer[] a = {1, 2, -3, 3 };
        List<Integer> ls = Arrays.asList(a);
        System.out.println("Maximum contiguous sum is " +
                lszeroSum(ls));
    }
}
