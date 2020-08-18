package com.study.codility.counting;

import java.util.Arrays;

/**
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 *
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 *
 */
public class MaxCounters {
    public static int[] solution(int N, int[] A){
        int[] res = new int[N];
        int max = 0;


//        for (int k = 1; k <= A.length;k++){
//            if (A[k - 1] >=1 && A[k - 1] <= N){
//                res[A[k - 1] - 1] +=1;
//                if (res[A[k - 1] - 1] > max){
//                    max = res[A[k - 1] - 1];
//                }
//            } else {
//                if (A[k - 1] == N + 1) {
//                   if (res[0] != max) {
//                       Arrays.fill(res, max);
//                   }
//                }
//            }
//        }

        for (int k = 0; k< A.length; k ++){
            if (A[k] == N +1){
                Arrays.fill(res, max);
            } else {
                res[A[k] - 1] +=1;
                if (max < res[A[k] - 1]){
                    max = res[A[k] - 1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{3,4,4,6,1,4,4}));
        //System.out.println(solution(1, new int[]{2, 1, 1, 2, 1}));
    }
}
