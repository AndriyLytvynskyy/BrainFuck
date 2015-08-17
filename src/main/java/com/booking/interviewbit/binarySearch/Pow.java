package com.booking.interviewbit.binarySearch;

/**
 * Implement pow(x, n) % d.
 * <p/>
 * In other words, given x, n and d,
 * <p/>
 * find (xn % d)
 * <p/>
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 * <p/>
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 * <p/>
 * 2^3 % 3 = 8 % 3 = 2.
 */
public class Pow {

    public static double getMod(double a, double b) {
        return a % b < 0 ? (a % b) + b : a % b;
    }
    public int pow(int x, int n, int d) {

        long a = x;
        long res = 1L;

        while (n > 0) {

            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }

            a *= a;
            a %= d;
            n = n >> 1;

        }

        res = (res + d) % d;

        return (int) res;

    }

    public static void main(String[] args) {
//        System.out.println((71045970,41535484));

    }
}
