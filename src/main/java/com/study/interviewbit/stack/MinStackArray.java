package com.study.interviewbit.stack;

import java.util.Arrays;

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
public class MinStackArray {

    Integer[] elementData = new Integer[]{};

    public void push(int x) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
        elementData[oldCapacity++] = x;
    }

    public void pop() {
        if (elementData.length == 0){
            return;
        }
        int elementCount = elementData.length;
        int index = elementData.length - 1;

        Integer[] copy = new Integer[elementData.length-1];
        System.arraycopy(elementData, 0, copy, 0, index);
        elementData = copy;

    }

    public int top() {
        if (elementData.length == 0){
            return -1;
        }
        return elementData[elementData.length -1];
    }

    public int getMin() {
        if (elementData.length == 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (Integer elementDatum : elementData) {
            if (null != elementDatum) {
                if (elementDatum < min) {
                    min = elementDatum;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStackArray stack = new MinStackArray();
        stack.push(19);
        stack.push(10);
        stack.push(9);

        stack.pop();
        stack.pop();
        stack.pop();
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
