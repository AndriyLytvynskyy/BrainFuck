package com.study.interviewbit.binarySearch;

import java.util.List;

/**
Given a sorted array of integers, find the number of occurrences of a given target value.
        Your algorithm’s runtime complexity must be in the order of O(log n).
        If the target is not found in the array, return 0

        **Example : **
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return 2.
 */
public class CountElements {
    public int findCount(final List<Integer> a, int b, boolean searchFirst){
        int n = a.size();
        int low = 0;
        int high = n -1;
        int result = -1;
        while (low <=high){
            int mid = (low + high)/2;
            if (a.get(mid) == b){
                result = mid;
                if (searchFirst){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            else if (b<a.get(mid)){
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        return result;
    }
    public int findCount(final List<Integer> a, int b) {
        int lastIndex = findCount(a, b, false);
        if (lastIndex == -1){
            return 0;
        }
        int firstIndex = findCount(a, b, true);

        return (lastIndex - firstIndex + 1);
    }
}
