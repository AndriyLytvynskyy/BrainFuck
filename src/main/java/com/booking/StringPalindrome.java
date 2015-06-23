package com.booking;

/**
 * Created by Andrii_Lytvynskyi on 6/17/2015.
 */
public class StringPalindrome {

    public static void main(String[] args) {
        String inputString = "HelloWorld";
        StringBuilder sb = new StringBuilder(inputString).reverse();
        System.out.println(sb.toString());
    }
}
