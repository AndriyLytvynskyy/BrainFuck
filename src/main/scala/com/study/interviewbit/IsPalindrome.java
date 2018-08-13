package com.study.interviewbit;

/**
 * Created by Andrii_Lytvynskyi on 8/6/2015.
 */
public class IsPalindrome {
    public boolean isPalindrome(int a) {
        String s = String.valueOf(a);
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.equals(sb.toString());

    }

    public static void main(String[] args) {

    }
}
