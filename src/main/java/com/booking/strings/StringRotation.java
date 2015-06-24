package com.booking.strings;

/**Assume you have a method isSubstring which checks if one word is a substring
        of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
        using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
 */


public class StringRotation {
    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
/* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
        /* concatenate si and si within new buffer */
            String slsl = s1 + s1;
            return true;//isSubstring(slsl, s2);
        }
         return false;
        }

    public static void main(String[] args) {

    }
}
