package com.study.interviewbit.strings;

import java.util.Stack;

/**
 * Utility: Ways to reverse a string
 *
 * Stack
 * StringBuilder
 * Direct character exchange
 *
 */
public class WaysToReverseStrings {

    public static void main(String[] args) {
        String inputString = "HelloWorld";
        char[] chars = inputString.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character ch: chars){
            stack.push(ch);
        }
        int i = 0;
        while (!stack.isEmpty()){
            chars[i] = stack.pop();
            i++;
        }
        String s = new String(chars);
        System.out.println(s);

        StringBuilder sb = new StringBuilder(inputString).reverse();
        System.out.println(sb.toString());


        chars = inputString.toCharArray();
        for (int j = 0; j < chars.length/2; j++) {
            char temp = chars[j];
            chars[j] = chars[chars.length - 1 - j];
            chars[chars.length - 1 - j] = temp;

        }
        System.out.println(chars);
    }
}
