package com.study.interviewbit.hash;

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
    public static ArrayList<Integer> lszeroSum(List<Integer> a) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int start = 0;
        //int end = 0;
        int length = 0;
        for (int i = 0; i < a.size(); i++){
            sum += a.get(i);
            if (map.containsKey(sum)){
                int last = map.get(sum);
                if (i - last > length){
                    start = last;
                    length = i - last;
                }
            }else{
                map.put(sum, i);
            }
        }

        for (int i = 0; i < length; i++){
            ans.add(a.get(start + 1 + i));
        }

        return ans;
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
        //Integer[] a = {15, -2, 2, -8, 1, 7, 10, 23};

        Integer[] a = {1 ,2 ,-2 ,4 ,-4};
        //Integer[] a = {1, 2, -3, 3 };
        //Integer[] a = { -1, 1, 1, -1, -1, 1, 1, -1 };

        List<Integer> ls = Arrays.asList(a);
        System.out.println("Maximum contiguous sum is " +
                lszeroSum(ls));
    }
}
