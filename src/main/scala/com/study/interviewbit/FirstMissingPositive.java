package com.study.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

/**Given an unsorted integer array, find the first missing positive integer.

        Example:

        Given [1,2,0] return 3,

        [3,4,-1,1] return 2,

        [-8, -7, -6] returns 1


        Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingPositive {

    public static  int firstMissingPositive(ArrayList<Integer> a) {
        Collections.sort(a);
        int res = 1;

        for (int i = 0; i< a.size();i++) {
            int nextEl = a.get(i);
            if (nextEl > res){
                return res;
            }
            if ((nextEl != res) ){
                if (nextEl - res == 1){
                    res = res + 2;
                    break;
                }
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println(firstMissingPositive(list));
    }
}
