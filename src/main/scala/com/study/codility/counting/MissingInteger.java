package com.study.codility.counting;
import java.util.*;
/**
 * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 */
public class MissingInteger {
    public int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i ++){
            if (A[i] > max){
                max = A[i];
            }
            set.add(A[i]);
        }
        for (int i = 1; i <= max + 1;i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return 1;
    }
}
