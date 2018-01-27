package com.booking.interviewbit.trees;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * <p>
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 *
 */

public class IdenticalBinaryTrees {
    public static int isSameTree(TreeNode A, TreeNode B) {
        //both identical
        if (A ==null && B == null){
            return 1;
        }

        if ((A != null) && (B != null)) {
            return ((A.val == B.val) ? 1 : 0) * isSameTree(A.left, B.left) * isSameTree(A.right, B.right);
        }
        return 0;


    }

    public static void main(String[] args) {
        TreeNode treeNodeIdent = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        treeNodeIdent.left = left;
        treeNodeIdent.right = right;

        TreeNode treeNodeIdent1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2);
        treeNodeIdent1.left = left1;
        treeNodeIdent1.right = right1;
        System.out.println(isSameTree(treeNodeIdent, treeNodeIdent1));

    }
}
