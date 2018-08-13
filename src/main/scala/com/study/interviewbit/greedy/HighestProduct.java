package com.study.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
 *
 *[0, -1, 3, 100, 70, 50]
 => 70*50*100 = 350000

 Detailed description can be found here https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
 *
 */
public class HighestProduct {

    public int maxp3(ArrayList<Integer> A) {
        int n = A.size();
        if (n< 3){
            return -1;
        }
        Collections.sort(A);

        return Math.max(A.get(0) *A.get(1) * A.get(n-1), A.get(n-1) * A.get(n-2)* A.get(n-3));

    }
}
