package com.study.leet;

import java.util.Arrays;

/**
 * @author andrii_lytvynskyi
 */
public class ReorderLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            // letter logs come before digit logs or (letter logs are less than digit logs)

            // @return a negative integer, zero, or a positive integer as the
            //     *         first argument is less than, equal to, or greater than the
            //     *         second.
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {
        reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
    }
}
