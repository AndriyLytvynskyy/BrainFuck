package com.study.interviewbit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Lytvynskyi on 8/10/2015.
 */
public class Factorial {
    static Map<Integer, Double> cache = new HashMap<>();

    public static Double factorial(int n){
        if (n==1){
            return (double)1;
        }
        return cache.computeIfAbsent(n, (key) -> key*factorial(key-1));

    }

    public static void main(String[] args) {
        Double number = factorial(9247);
        int trailingZeros = 0;
        String numString = String.valueOf(number);
        StringBuilder stringBuilder = new StringBuilder(numString);
        for (Character ch : stringBuilder.reverse().toString().toCharArray()) {
            if (ch.equals('0')){
                trailingZeros++;
            }

        }
        System.out.println(trailingZeros);

    }

}
