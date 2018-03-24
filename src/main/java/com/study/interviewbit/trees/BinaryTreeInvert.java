package com.study.interviewbit.trees;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, invert the binary tree and return it.
 *  Look at the example for more details.
 *
 * Solution is explained here:
 * https://leetcode.com/problems/invert-binary-tree/solution/
 *
 */
public class BinaryTreeInvert {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

    }
}
