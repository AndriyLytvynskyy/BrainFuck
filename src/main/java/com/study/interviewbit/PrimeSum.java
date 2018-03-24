package com.study.interviewbit;

import java.util.*;

/**
 * Created by Andrii_Lytvynskyi on 8/4/2015.
 */
public class PrimeSum {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> primesum(int A) {
        Set<Integer> set = new HashSet<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= A; i++) {
            if (isPrime(i)) {
                set.add(i);
            }
        }

        for (Integer element : set) {
            if (set.contains(A - element)) {
                ArrayList<Integer> subRes = new ArrayList<Integer>();
                subRes.add(element);
                subRes.add(A - element);
                Collections.sort(subRes);
                res.add(subRes);
            }
        }


        ArrayList<Integer> solution = res.get(res.size() - 1);
        for (ArrayList<Integer> list : res) {
            int a = solution.get(0);
            int b = solution.get(1);
            int c = list.get(0);
            int d = list.get(1);

            if (a <= b && c <= d) {
                if ((a < c) || (a == c) && (b < d)) {
                    ;
                } else {
                    solution = list;
                }
            }


        }
        return solution;
    }


        public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= A.size()-1; i++) {
                System.out.println(i+B % A.size()-1);
                stack.push(A.get((i + B) % A.size()));
            }

            return ret;
        }

    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int distance = 0;
        //System.out.println(X.get(0));
        //System.out.println(Y.get(0));

        for  (int i = 1;i<=X.size()-2;i++){
            distance += Math.sqrt(Math.pow(X.get(i)-Y.get(i), 2) + Math.pow(X.get(i+1)-Y.get(i+1), 2));
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(11));
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(-7);
//        list.add(-13);
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        list1.add(1);
//        list1.add(-5);
//
//        System.out.println(coverPoints(list, list1));


    }

}
