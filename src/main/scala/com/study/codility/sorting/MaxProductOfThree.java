package com.study.codility.sorting;

import java.util.Arrays;

/**
 * @author andrii_lytvynskyi
 */
public class MaxProductOfThree {
    public int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);
        return Math.max(A[0] * A[1] * A[A.length - 1], A[A.length - 1] * A[A.length - 2] * A[A.length - 3]);
    }
}
