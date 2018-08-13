package com.study.interviewbit;

import java.util.ArrayList;

/**
 * Created by Andrii_Lytvynskyi on 8/4/2015.
 */
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int A) {
        int numRows = A;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (A == 0)
            return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            res.add(new ArrayList<>());
            res.get(i).add(1);
            for (int j = 0; j < i - 1; j++) {
                int num = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
                res.get(i).add(num);
            }

            res.get(i).add(1);

        }
        return res;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
