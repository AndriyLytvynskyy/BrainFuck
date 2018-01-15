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


// Definition for binary tree
class TreeNodeIdent {
    int val;
    TreeNodeIdent left;
    TreeNodeIdent right;

    TreeNodeIdent(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class IdenticalBinaryTrees {
    public static int isSameTree(TreeNodeIdent A, TreeNodeIdent B) {
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
        TreeNodeIdent treeNodeIdent = new TreeNodeIdent(1);
        TreeNodeIdent left = new TreeNodeIdent(2);
        TreeNodeIdent right = new TreeNodeIdent(3);
        treeNodeIdent.left = left;
        treeNodeIdent.right = right;

        TreeNodeIdent treeNodeIdent1 = new TreeNodeIdent(1);
        TreeNodeIdent left1 = new TreeNodeIdent(3);
        TreeNodeIdent right1 = new TreeNodeIdent(2);
        treeNodeIdent1.left = left1;
        treeNodeIdent1.right = right1;
        System.out.println(isSameTree(treeNodeIdent, treeNodeIdent1));

    }
}
