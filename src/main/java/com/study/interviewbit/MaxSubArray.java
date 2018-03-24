package com.study.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
  For example:

  Given the array [−2,1,−3,4,−1,2,1,−5,4],

  the contiguous subarray [4,−1,2,1] has the largest sum = 6.

  For this problem, return the maximum sum.
 *
 *
 *
 */

public class MaxSubArray {

    public static int maxSubArray(final List<Integer> a) {
        int initialSum=a.get(0);
        int maxSum=a.get(0);
        for(int i=1;i<a.size();i++){
            initialSum=Math.max(
                    initialSum+a.get(i),a.get(i));
            maxSum= Math.max(maxSum, initialSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-2);
        list.add(-1);
        //list.add(1);

        maxSubArray(list);

    }
}
