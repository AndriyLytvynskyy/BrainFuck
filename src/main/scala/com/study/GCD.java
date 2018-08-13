package com.study;

/**
 * Reads two command-line arguments p and q and computes the greatest
 * common divisor of p and q using Euclid's algorithm.
 */

public class GCD {

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    public static int gcdNonRecursive(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcdRecursive(9,6));
        //System.out.println(gcdNonRecursive(12500, 125));
    }
}
