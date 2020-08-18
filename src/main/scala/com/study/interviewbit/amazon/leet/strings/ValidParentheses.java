package com.study.interviewbit.amazon.leet.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author andrii_lytvynskyi
 */
public class ValidParentheses {
    static Map<Character, Character> parenthCombs = new HashMap<>();
    static {
        parenthCombs.put(')', '(');
        parenthCombs.put(']', '[');
        parenthCombs.put('}', '{');
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            //if this is a closing bracket
            if (parenthCombs.containsKey(ch)) {
                Character lastInserted = stack.isEmpty()?stack.push('#'):stack.pop();
                if (lastInserted != parenthCombs.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
       return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("]"));
    }
}
