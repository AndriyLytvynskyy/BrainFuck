package com.study.interviewbit.dynamic;

/**
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 *
 *
 */
public class Stairs {
    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    // Returns number of ways to reach s'th stair
    static int climbStairs(int A)
    {
        return fib(A + 1);
    }



    public static void main(String[] args) {
        System.out.println(climbStairs(3));

    }

}
