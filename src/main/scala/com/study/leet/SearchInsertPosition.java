package com.study.leet;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * @author andrii_lytvynskyi
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length;i++) {

            if (nums[i] == target || nums[i] > target) {
                result = i;
                break;
            }
            result = i + 1;

        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        //System.out.println(searchInsert(new int[]{1,3,5,6}, 0));

    }

}
