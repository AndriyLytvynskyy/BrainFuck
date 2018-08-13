package com.study.interviewbit.stack;

import java.util.Stack;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *
  push(x) – Push element x onto stack.
  pop() – Removes the element on top of the stack.
  top() – Get the top element.
  getMin() – Retrieve the minimum element in the stack.
 *
 *
 */
public class MinStackWithStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.size() == 0){
            return;
        }
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        if (stack.size() == 0){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.size() == 0){
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        MinStackWithStack stack = new MinStackWithStack();
        stack.push(19);
        stack.push(10);
        stack.push(9);

        stack.pop();
        stack.pop();
        //stack.pop();
        System.out.println(stack);
//
//        Stack<Integer> stack1 = new Stack<Integer>();
//        stack1.push(19);
//        stack1.push(10);
//        stack1.push(9);
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1);

    }
}
