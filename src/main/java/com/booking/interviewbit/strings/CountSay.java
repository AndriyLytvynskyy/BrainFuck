package com.booking.interviewbit.strings;

import java.util.Collections;
import java.util.List;

/**The count-and-say sequence is the sequence of integers beginning as follows:

        1, 11, 21, 1211, 111221, ...
        1 is read off as one 1 or 11.
        11 is read off as two 1s or 21.

        21 is read off as one 2, then one 1 or 1211.

        Given an integer n, generate the nth sequence.

        Note: The sequence of integers will be represented as a string.

        Example:

        if n = 2,
        the sequence is 11.
 */
public class CountSay {
    public static String countAndSay(int a) {

        String result = "1";
        int i = 1;

        while (i < a) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }
    public int singleNumber(final List<Integer> a) {
        Collections.sort(a);
        //1 1 2 2 3 3
        //1 1 2 3 3
        for (int i = 1; i < a.size();i=i + 2) {
            if (i<a.size()-1) {
                if (a.get(i) != a.get(i - 1)) {
                    return a.get(i);
                }
            }
        }
        return a.get(a.size()-1);
    }
    public static int lengthOfLastWord(final String a) {
        String trimmed = a.trim();
        if (trimmed.indexOf(' ')!= -1){
            return trimmed.substring(trimmed.lastIndexOf(' '), trimmed.length()-1).length();
        }
        return trimmed.length();
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World  "));
    }
}
