package com.study.interviewbit.trees;

/**
 *
 *  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 *
 *      1
       / \
      2   2
     / \ / \
    3  4 4  3
 *
 */

public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode A, TreeNode B) {
        //both identical
        if (A ==null && B == null){
            return 1;
        }

        if ((A != null) && (B != null)) {
            return ((A.val == B.val) ? 1 : 0) * isSymmetric(A.left, B.right) * isSymmetric(A.right, B.left);
        }
        return 0;


    }


}
