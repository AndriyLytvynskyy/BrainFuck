package com.study.interviewbit.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

   If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Given numerator = 1, denominator = 2, return "0.5"
   Given numerator = 2, denominator = 1, return "2"
   Given numerator = 2, denominator = 3, return "0.(6)"
 *
 * Explanation of the solution can be found here http://qa.geeksforgeeks.org/3910/qa.geeksforgeeks.org/3910/return-the-fraction-as-string
 *
 *  In Java : https://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
 *
 *
 */
public class Fraction {
    public String fractionToDecimal_MoreEffective(int numerator, int denominator) {
        long a=numerator,b=denominator;
        if(a%b==0) return String.valueOf(a/b);
        Map<Long,Integer> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        if((a>0&&b<0)||(a<0&&b>0)) res.append("-");
        a=Math.abs(a);
        b=Math.abs(b);
        res.append(a/b+".");
        a=(a%b)*10;
        while(!map.containsKey(a)){
            map.put(a,res.length());
            res.append(String.valueOf(a/b));
            a=(a%b)*10;
            if(a==0) return res.toString();
        }
        return res.insert(map.get(a),"(").append(")").toString();
    }

    public static String fractionToDecimal(int A, int B) {
        // zero numerator
        if (A == 0) return "0";
        if (B ==0){
            return "";
        }
        String result = "";
        // is result is negative
        if ((A < 0) ^ (B < 0)) {
            result += "-";
        }

        // convert int to long

        long num = Math.abs((long)A);
        long den = Math.abs((long)B);


        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0) {
            return result;
        }

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(87,22));
        System.out.println(1^1);
    }
}
