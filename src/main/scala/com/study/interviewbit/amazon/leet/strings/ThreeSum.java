package com.study.interviewbit.amazon.leet.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 *
 * https://www.geeksforgeeks.org/faster-process-sorted-array-unsorted-array/
 * https://fizzbuzzed.com/top-interview-questions-1/
 *
 * https://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
 *
 * @author andrii_lytvynskyi
 */
public class ThreeSum {
    static List<List<Integer>> threeSumTwoPointer(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {

                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ++j;
                    result.add(triplet);
                    while (j < k && nums[j] == nums[j - 1])
                        ++j;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumHash(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == (nums[i - 1]))
                continue;
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int x = -(nums[i] + nums[j]);
                if (s.contains(x)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(x);
                    result.add(new ArrayList<>(triplet));
                    while ((j + 1 < nums.length) && nums[j + 1] == nums[j])
                        ++j;

                } else {
                    s.add(nums[j]);
                }
            }
        }
        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tripletSum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - tripletSum);
                if (diff == 0) {
                    return tripletSum;
                }
                if (diff < min) {
                    min = diff;
                    result = tripletSum;

                }
                if (tripletSum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    static void findTriplets(int arr[], int n) {
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false) {
            System.out.printf(" No Triplet Found\n");
        }
    }

    public static void main(String[] args) {
        //        List<Integer> input = Arrays.asList(-1, 0, 1, 2, -1, -4);
        //        Integer[] arr =input.toArray(new Integer[0]);

        int arr[] = { 0, 1, 2 };
        int arr1[] = { -1, 2, 1, -4 };

        //int arr[] = {0, 1, 2};

        int n = arr.length;
        System.out.println(threeSumClosest(arr, 0));
        System.out.println(threeSumClosest(arr, 1));
        //System.out.println(threeSumClosest(arr1, 1));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length;i ++){
            if (i == 0 || nums[i -1] != nums[i]) { //here we eliminating duplicates cause we need unique triplets
                twoSumPointers (i, nums, result);
            }
        }
        return result;
    }

    private void twoSumPointers(int i, int[] nums, List<List<Integer>> result) {
            int lowIndex = i + 1;
            int highIndex = nums.length - 1;

            while (lowIndex < highIndex) {
                int targetSum = nums[lowIndex] + nums[highIndex] + nums[i];
                if (targetSum < 0 || ( lowIndex > i + 1 && nums[lowIndex] == nums[lowIndex - 1])) {
                    ++lowIndex;
                } else if (targetSum > 0 || (highIndex < nums.length - 1 && nums[highIndex] == nums[highIndex + 1])) {
                    --highIndex;
                } else {
                    //output triplet
                    result.add(Arrays.asList(nums[i], nums[lowIndex], nums[highIndex]));
                    lowIndex = lowIndex + 1;
                    highIndex = highIndex - 1;
                }
            }

    }
}
