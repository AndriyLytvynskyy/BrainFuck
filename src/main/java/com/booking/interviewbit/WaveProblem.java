package com.booking.interviewbit;

import java.util.ArrayList;
import java.util.Collections;


//public class Solution {
//    public ArrayList<Integer> wave(ArrayList<Integer> A) {
//
//        Collections.sort(A);
//        int n = A.size();
//
//        for (int i = 2; i <= n; i += 2) {
//            exch(A, i - 2, i - 1);
//        }
//
//        return A;
//
//    }
//
//    private void exch(ArrayList<Integer> A, int i, int j) {
//        int temp = A.get(i);
//        A.set(i, A.get(j));
//        A.set(j, temp);
//    }
//
//}

public class WaveProblem {
    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Collections.sort(a);
        for (int i = 1;i<=(a.size()-1);i++){
            if (i%2 != 0){
                for (int j=i;j>=i-1;j--){
                    res.add(a.get(j));
                }
            }
        }
        if (res.size() < a.size()){
            res.add(a.get(a.size()-1));
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        res.add(2);
        res.add(3);
        res.add(4);
        res.add(5);
        res.add(6);
        System.out.println(wave(res));
    }

}
