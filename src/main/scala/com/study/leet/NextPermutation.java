package com.study.leet;

import java.util.Arrays;

/**
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author andrii_lytvynskyi
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = findDecreasingElement(nums);
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) { //here we swap with first element larger than decreasing element
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * Find first number which is decreasing: start from left, go to right
     *
     * @param nums array
     * @return
     */
    private int findDecreasingElement(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        return i;
    }


    /**
     * Reverse list of elements
     * @param nums
     * @param start
     */
    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        //new NextPermutation().nextPermutation(new int[]{1,2,3});
        new NextPermutation().nextPermutation(new int[]{3,2,1});

    }

}
