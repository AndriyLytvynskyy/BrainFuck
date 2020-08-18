package com.study.leet;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 * @author andrii_lytvynskyi
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, 0, n-1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1) {
            return binarySearch(nums, 0, n - 1, target);
        }

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (nums[pivot] == target) {
            return pivot;
        }
        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        return binarySearch(nums, pivot+1, n-1, target);

    }


    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        int mid = (low + high)/2;
        if (key == arr[mid]) {
            return mid;
        }
        if (key > arr[mid]) {
            return binarySearch(arr, (mid + 1), high, key);
        }
        return binarySearch(arr, low, (mid -1), key);
    }

    static int findPivot(int arr[], int low, int high){

        // base cases
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }

        int mid = (low + high)/2;
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return (mid - 1);
        }
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1);
        }
        return findPivot(arr, mid + 1, high);
    }


    public static void main(String[] args) {

    }
}
