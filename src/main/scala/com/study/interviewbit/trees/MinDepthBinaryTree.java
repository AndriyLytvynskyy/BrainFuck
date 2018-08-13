package com.study.interviewbit.trees;


/**
 * Given a binary tree, find its minimum depth.
   The minimum depth is the number of nodes along the shortest path from the root node down
   to the nearest leaf node.
 *
 */
public class MinDepthBinaryTree {
    public static int minDepth(TreeNode A) {
        if (A == null) {
            return Integer.MAX_VALUE;
        }
        if (A.right == null && A.left == null){
            return 1;
        }
        return Math.min(minDepth(A.right), minDepth(A.left)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t7.right = t1;
        t7.left = t2;
        t2.right = t3;

        System.out.println(minDepth(t7));


    }
}
