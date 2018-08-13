package com.study;

/**
 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
        or 3 steps at a time. Implement a method to count how many possible ways the
        child can run up the stairs.
 **/

public class ChildRunningStairs {

    public static int getHowManyWays(int n){
        if (n < 0){
            return 0;
        }
        if (n == 0){
            return 1;
        }
        return getHowManyWays(n-1) + getHowManyWays(n-2) + getHowManyWays(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(getHowManyWays(50));
    }

}
