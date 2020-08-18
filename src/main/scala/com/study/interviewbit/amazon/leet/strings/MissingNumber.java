package com.study.interviewbit.amazon.leet.strings;

import java.util.Arrays;

/**
 * @author andrii_lytvynskyi
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }

        for (int i = 1; i < nums.length; i ++ ) {
            int expectedNumber = nums[i - 1] + 1;
            if (nums[i] !=  expectedNumber) {
                return expectedNumber;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1}));
    }
}
