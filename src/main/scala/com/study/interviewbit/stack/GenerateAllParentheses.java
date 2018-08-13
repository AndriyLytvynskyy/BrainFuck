package com.study.interviewbit.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

   The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

   Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Use Stack to get the last inserted element and compare it with incoming

 */
public class GenerateAllParentheses {

     public static int isValid(String A) {

        char[] chars = A.toCharArray();
        Stack<Character> stack = new Stack();
        Map<Character, Character> validPair = new HashMap<Character, Character>();
        validPair.put('[', ']');
        validPair.put('{', '}');
        validPair.put('(', ')');
        for (Character ch: chars){
            if ((ch == '[') || (ch == '{') || (ch == '(')) {
                stack.push(ch);
            }
            else {
                if (!stack.isEmpty()) {
                    Character openChar = stack.pop();
                    if (validPair.get(openChar) != ch) {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
        return (stack.isEmpty()?1:0);
    }

    public static void main(String[] args) {
        System.out.println(isValid("])"));
    }

}
