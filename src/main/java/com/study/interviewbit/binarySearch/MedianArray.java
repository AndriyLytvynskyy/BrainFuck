package com.study.interviewbit.binarySearch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**There are two sorted arrays A and B of size m and n respectively.

        Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

        The overall run time complexity should be O(log (m+n)).

        Sample Input
 */
public class MedianArray {
    public static double findMedianSortedArrays(final List<Integer> A1, final List<Integer> B1) {
        Integer[] A = new Integer[A1.size()];
        A = A1.toArray(A);
        Integer[] B = new Integer[B1.size()];
        B = A1.toArray(B);

        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            Integer[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


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
    public double findMedianSortedArrays1(final List<Integer> a, final List<Integer> b) {
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
        List<Integer> A = Arrays.asList();
        List<Integer>  B = Arrays.asList(20);

        System.out.println(findMedianSortedArrays(A, B));
//        System.out.println((71045970,41535484));

    }
}
