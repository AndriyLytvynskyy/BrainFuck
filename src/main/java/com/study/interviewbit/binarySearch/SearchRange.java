package com.study.interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * Example:
 * <p/>
 * Given [5, 7, 7, 8, 8, 10]
 * <p/>
 * and target value 8,
 * <p/>
 * return [3, 4].
 */
public class SearchRange {
    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        int firstIndex = findIndex(a, b, true);
        int lastIndex = findIndex(a, b, false);
        result.add(firstIndex);
        result.add(lastIndex);

        return result;
    }

    private static int findIndex(List<Integer> a, int b, boolean searchFirstPosition) {
        int n = a.size();
        int low = 0;
        int high = n - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (b == a.get(mid)) {
                result = mid;
                if (searchFirstPosition) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (b < a.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(5, 7, 7, 8, 8, 10);

        System.out.println(searchRange(ls, 8));

    }
}

