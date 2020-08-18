package com.study.leet;

import java.util.Arrays;

/**
 * @author andrii_lytvynskyi
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[0][K];
        Arrays.sort(points, (el1, el2) -> {
            Double v1 = Math.sqrt(el1[0] * el1[0] + el1[1] * el1[1]);
            Double v2 = Math.sqrt(el2[0] * el2[0] + el2[1] * el2[1]);
            return v1.compareTo(v2);

        });
        for (int i = 0; i < K; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }

//    public static void main(String[] args) {
//        kClosest(int[][] points, int K)
//    }
}
