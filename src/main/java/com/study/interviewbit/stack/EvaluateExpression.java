package com.study.interviewbit.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

   Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Example:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 Algorithm can be found here: https://en.wikipedia.org/wiki/Reverse_Polish_notation
 *
 *
 */
public class EvaluateExpression {

    public static int evalRPN(ArrayList<String> A) {
        Set<String> operators = new HashSet<String>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<String> operandStack = new Stack<String>();
        String result = null;
        for (String token : A) {
            if (operators.contains(token)) {
                int operand_2 = Integer.valueOf(operandStack.pop());
                int operand_1 = Integer.valueOf(operandStack.pop());
                switch (token) {
                    case ("+"):
                        result = String.valueOf(operand_1 + operand_2);
                        break;
                    case ("-"):
                        result = String.valueOf(operand_1 - operand_2);
                        break;
                    case ("*"):
                        result = String.valueOf(operand_1 * operand_2);
                        break;
                    case ("/"):
                        result = String.valueOf(operand_1 / operand_2);
                        break;
                }
                operandStack.push(result);
            } else {
                //token is an operand
                operandStack.push(token);
            }
        }
        return Integer.valueOf(operandStack.pop());
    }

    public static void main(String[] args) {

    }

}
