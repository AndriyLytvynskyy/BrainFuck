package com.study.interviewbit.amazon.leet.recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=sz1qaKt0KGQ - damn that was great, man
 *
 * https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/generateNMatchedParenStrings.java
 * @author andrii_lytvynskyi
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        directedGenerateBalancedParentheses(n, n, "", result); // kick off the recursion
        return result;
    }

    private static void directedGenerateBalancedParentheses(int numLeftParensNeeded, int numRightParensNeeded,
            String parenStringInProgress, List<String> result) {

        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(parenStringInProgress);
            return;
        }

        if (numLeftParensNeeded > 0) {
            directedGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded,
                    parenStringInProgress + "(", result);
        }

        if (numLeftParensNeeded < numRightParensNeeded) {
            directedGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1,
                    parenStringInProgress + ")", result);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(2);
    }



}
