package com.study.codility.timecomplexity;

/**
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
 *
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 *
 * Write a function:
 *
 * int solution(int X, int Y, int D);
 *
 * that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
 */
public class FrogJump {
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        if (X >= Y){
            return 0;
        }
        if (D > Y){
            return 1;
        }
        int dist = Y - X;
        return (int)Math.ceil(1.0 * dist/D);
    }
    public static void main(String[] args) {
        System.out.println(solution(1,5,2));
    }
}
