package com.booking.interviewbit.binarySearch;

/**
 * Implement int sqrt(int x).
 * <p/>
 * Compute and return the square root of x.
 * <p/>
 * If x is not a perfect square, return floor(sqrt(x))
 * <p/>
 * Example :
 * <p/>
 * Input : 11
 * Output : 3
 */
public class SQRT {
    public static  int sqrt(int a) {
        long low = 0;
        long high = a;
        int result = 1;
        while (low <= high) {
            long mid = (low + (high-low) / 2);
            if ((mid * mid > a)) {
                high = mid - 1;
            } else if (mid * mid <= a) {
                result = (int) mid;
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
        System.out.println(Integer.MAX_VALUE);
    }
}
