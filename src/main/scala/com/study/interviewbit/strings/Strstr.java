package com.study.interviewbit.strings;
/**
Implement strStr().

        strstr - locate a substring ( needle ) in a string ( haystack ).
 */
public class Strstr {
    public int strStr(final String haystack, final String needle) {
        if ((needle.isEmpty()) || (haystack.isEmpty())){
            return -1;
        }
        return haystack.indexOf(needle);
    }
}

