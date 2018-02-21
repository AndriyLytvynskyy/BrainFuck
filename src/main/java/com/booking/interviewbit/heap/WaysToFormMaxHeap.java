package com.booking.interviewbit.heap;

import java.util.Arrays;
import java.util.List;

/**
 * Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link

 So now the problem statement for this question is:
 How many distinct Max Heap can be made from n distinct integers

 In short, you have to ensure the following properties for the max heap :

 Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. )

 Every node is greater than all its children

 Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

 Following are the possible max heaps from these 4 numbers :
 *
 *
 *
 * How to build a heap is show here: https://www.youtube.com/watch?v=WsNQuCa_-PU
 *
 * https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/
 *
 */
public class WaysToFormMaxHeap {
    public int solve(int A) {
        return 0;
    }

    public static void main(String[] args) {
       List<Integer> list =  Arrays.asList(1,2,3,4,5);
       for ( int i = list.size()/2; i > 0; i -- ){

       }
    }


}
