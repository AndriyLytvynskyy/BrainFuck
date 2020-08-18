package com.study.leet;

/**
 * @author andrii_lytvynskyi
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];

        for (int i = 1; i < nums.length; i ++ ){
            curr = nums[i] + curr;
            max = Math.max(max, curr);
        }
        return max;
    }
}
