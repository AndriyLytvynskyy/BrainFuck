package com.study.interviewbit.trees;

/**
 * Given a binary tree, find its maximum depth.

    The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class MaxDepthBinaryTree {
    public static int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return Math.max(maxDepth(A.right), maxDepth(A.left)) + 1;

    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        t0.left = t1;
        System.out.println(maxDepth(t0));
    }

}
