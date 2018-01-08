package com.booking.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PermutationKSequence {
    static public String findPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        // create an array of factorial lookup
        if (k > factorial(n)) return "";
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / factorial(n - i);
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial(n - i);
        }
        return String.valueOf(sb);
    }

    static int factorial(int n) {
        if (n > 12) {
            // this overflows in int. So, its definitely greater than k
            // which is all we care about. So, we return INT_MAX which
            // is also greater than k.
            return Integer.MAX_VALUE;
        }
        // Can also store these values. But this is just < 12 iteration, so meh!
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation(2, 2));
    }
}
