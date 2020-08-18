package com.study.interviewbit.amazon.leet.strings;

import java.util.Arrays;

/**
 * @author andrii_lytvynskyi
 */
public class ThreeSumClosestJava {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && diff != 0;) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    ++lo;
                else
                    --hi;
            }
            i = i + 1;
        }
        return target - diff;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }
}
