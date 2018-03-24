package com.study.interviewbit.strings;

/**
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Example:

 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 */
public class Palindrome {
    public static int isPalindrome(String a) {
        String replaced = a.replaceAll("\\P{Alnum}", "");

        StringBuilder reversed = new StringBuilder(replaced).reverse();

        return (replaced.equalsIgnoreCase(reversed.toString())?1:0);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
