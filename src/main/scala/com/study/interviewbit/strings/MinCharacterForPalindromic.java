package com.study.interviewbit.strings;

/**
 * You are given a string. The only operation allowed is to insert characters in the beginning of the string.
 * How many minimum characters are needed to be inserted to make the string a palindrome string.

     Example:
     Input: ABC
     Output: 2
     Input: AACECAAAA
     Output: 2
 *
 *  More details with solution with LPS can be found here:
 *  https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
 *  https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 *
 */
public class MinCharacterForPalindromic {

    private static int solveSimple(String A) {
        int n = A.length();
        for(int i = n; i > 0; i--){
            if(isPalindrome(A.substring(0,i))){
                //if string is pallindrome then we need to add only elements after this string
                return n-i;
            }
        }
        return 0;
    }

    private static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s).reverse();
        return sb.toString().equalsIgnoreCase(s);
    }

    public static int solveWithLPS(String A) {
        return minCharsToAddToMakeStringPalindromic(A);
    }

    static int[] computeLPSArray(char[] str) {
        int M = str.length;
        int[] lps = new int[M];

        int len = 0;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        int i = 1;
        while (i < M) {
            if (str[i] == str[len]) {
                len++;
                lps[i] = len;
                i++;
            } else // (str[i] != str[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    static int minCharsToAddToMakeStringPalindromic(String str) {
        StringBuilder sb = new StringBuilder(str);
        String revStr = sb.reverse().toString();

        // Get concatenation of string, special character
        // and reverse string
        String concat = str + "$" + revStr;

        //  Get LPS array of this concatenated string
        int[] lps = computeLPSArray(concat.toCharArray());

        // By subtracting last entry of lps vector from
        // string length, we will get our result
        return (str.length() - lps[lps.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(solveSimple("banana"));
    }
}
