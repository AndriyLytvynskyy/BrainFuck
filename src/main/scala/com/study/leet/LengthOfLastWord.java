package com.study.leet;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return strs.length > 0?strs[strs.length - 1].length():0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
    }
}
