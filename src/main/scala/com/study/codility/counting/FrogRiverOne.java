package com.study.codility.counting;

import java.util.HashSet;
import java.util.Set;

/**
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 *
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 *
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves).
 * You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 */
public class FrogRiverOne {
    public static int solution(int X, int[] A){
        Set<Integer> set = new HashSet<>();
        for (int time = 0; time < A.length; time ++){
            if (!set.contains(A[time])){
                set.add(A[time]);
                X--;
            }
            if (X==0) return time;
        }
        return -1;
    }
}
