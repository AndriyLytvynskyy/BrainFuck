package com.study.codility.prefixsums;

/**
 * @author andrii_lytvynskyi
 */
public class PairCount {
    public int solution(int[] A) {
        // write your code in Java SE 8
//        int pairCount = 0;
//        for (int i = 0; i< A.length - 1;i ++){
//            if (A[i] == 0){
//                for (int j = i + 1; j <= A.length - 1; j ++){
//                    if (A[j] == 1){
//                        if (pairCount > 1000000000){
//                            return pairCount;
//                        }
//                        pairCount +=1;
//                    }
//                }
//            }
//        }
//        return pairCount;
        int pairCount = 0;
        int startZeros = 0;
        for (int i = 0; i<A.length;i ++){
            if (A[i] == 0){
                startZeros++;
            }
            if (A[i] == 1){
                pairCount = pairCount + startZeros;
                if (pairCount > 1000000000){
                    return -1;
                }

            }

        }
        return pairCount;
    }
}
