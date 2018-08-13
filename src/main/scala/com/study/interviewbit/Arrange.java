package com.study.interviewbit;

import java.util.ArrayList;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 * Input : [1, 0]
 * Return : [0, 1]
 */
public class Arrange {

    public static void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);
        }

        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }

    }


    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(3);
        res.add(2);
        res.add(0);
        res.add(1);
        arrange(res);

    }
}
