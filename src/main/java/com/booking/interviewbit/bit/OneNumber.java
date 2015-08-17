package com.booking.interviewbit.bit;

import java.util.Arrays;
import java.util.List;

/**
 Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class OneNumber {

    public static int singleNumber(final List<Integer> a) {
        int res = 0;
        for (int el : a) {
            res = res ^ el;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(1, 1, 2, 3, 3)));
    }
}

