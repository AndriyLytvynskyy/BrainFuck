package com.booking.interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**There are two sorted arrays A and B of size m and n respectively.

        Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

        The overall run time complexity should be O(log (m+n)).

        Sample Input
 */
public class MedianArray {
    public int findLessOrGreater(final List<Integer> a, int b){
        int n = a.size();
        int low = 0;
        int high = n -1;
        int result = -1;
        int latestLowIndex;
        int latestHighIndex;

        while (low <=high){
            int mid = (low + high)/2;
            if (a.get(mid) == b){
                result = mid;
            }
            else if (b<a.get(mid)){
                high = mid - 1;

            }
            else {
                low = mid +1;

            }
        }
        return result;
    }
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        double result = 1.0;

        List<Integer> merged = Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
        Collections.sort(merged);
        int low = 0;
        final int size = merged.size();
        int high = size - 1;
        int mid = (low + high)/2;
        if (size%2 == 0){
            result = (merged.get(mid) + merged.get(mid +1))/2.0;
        } else {
            result = merged.get(mid);
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println((71045970,41535484));

    }
}
