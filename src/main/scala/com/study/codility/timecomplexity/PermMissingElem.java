package com.study.codility.timecomplexity;

import java.util.HashSet;
import java.util.Set;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 */
public class PermMissingElem {
    public static int solution(int[] A){
//        Set<Integer> set = new HashSet<>();
//        int max = Integer.MIN_VALUE;
//        int missing = 1;
//        for (int i = 0; i < A.length;i ++){
//            set.add(A[i]);
//            if (A[i] > max){
//                max = A[i];
//            }
//        }
//
//        for (int i = 1; i <= max;i++){
//            if (!set.contains(i)){
//                missing = i;
//                break;
//            }
//        }
//        return missing;
        long actualSum = 0;
        long n = A.length + 1;
        for (int i =0; i< A.length;i++){
            actualSum += A[i];

        }
        long expectedSum = (n * (n +1) /2);
        return (int)(expectedSum - actualSum);
    }

}
