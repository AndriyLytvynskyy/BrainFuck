package com.study.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author andrii_lytvynskyi
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        str = str.trim();
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
//        while(str.charAt(index) == ' ' && index < str.length())
//            index ++;
        //str = str.trim();

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
       // System.out.println(myAtoi("+"));
        System.out.println(myAtoi(" "));
//        System.out.println(myAtoi("-"));
//        System.out.println(myAtoi("       -421"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("words and 987"));
    }
}
