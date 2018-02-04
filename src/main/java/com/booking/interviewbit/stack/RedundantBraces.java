package com.booking.interviewbit.stack;


import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
 *
 * For example, (((a+b))+c) has duplicate brackets around “a+b”.
 * When we reach second “)” after a+b, we have “((” in the stack.
 * Since the top of stack is a opening bracket, we conclude that there are duplicate brackets..
 *
 * https://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/
 */
public class RedundantBraces {
    public int braces1(String a) {
        Stack<Character> stack = new Stack<Character>();
        boolean lastPopped = false;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '(' || a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*' || a.charAt(i) == '/') {
                stack.push(a.charAt(i));
            } else if (a.charAt(i) == ')') {
                boolean didPopSymbol = false;
                while(stack.peek() != '(') {
                    didPopSymbol = true;
                    stack.pop();
                }
                if(!didPopSymbol) return 1;
                stack.pop();
            }
        }
        return 0;
    }

    public static int braces(String A) {
        char[] chars = A.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : chars) {
            if ((ch == ')')) {
                Character top = stack.pop();
                if ((top == '(')) {
                    return 1;
                } else if (!stack.isEmpty() && stack.peek() == '('){
                    return 1;
                }
                else {
                    while (top != '(') {
                        top = stack.pop();
                    }
                }
            } else {
                stack.push(ch);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//
        System.out.println(braces("((a+b))"));
//        System.out.println(braces("(a)"));
//        System.out.println(braces("(a+b)"));
    }

}
