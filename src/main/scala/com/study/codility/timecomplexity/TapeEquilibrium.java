package com.study.codility.timecomplexity;

/**
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 *
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 *
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 *
 * We can split this tape in four places:
 *
 *  P = 1, difference = |3 − 10| = 7
 *  P = 2, difference = |4 − 9| = 5
 *  P = 3, difference = |6 − 7| = 1
 *  P = 4, difference = |10 − 3| = 7
 */
public class TapeEquilibrium {
    public static int solution(int[] A){
        long totalSum = 0;
        for (int i = 0; i < A.length;i++){
            totalSum = totalSum + A[i];
        }
        int minDiff = Integer.MAX_VALUE;
        long firstSum = 0;
        for (int p = 1; p <= A.length; p++){
             firstSum += A[p -1];


            minDiff = (int)Math.min(Math.abs(firstSum - (totalSum - firstSum)), minDiff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        //System.out.println(solution(new int[]{3,1,2,4,3}));
        System.out.println(solution(new int[]{-1000, 1000}));
    }
}
