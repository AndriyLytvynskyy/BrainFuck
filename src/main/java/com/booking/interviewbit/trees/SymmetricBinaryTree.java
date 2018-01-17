package com.booking.interviewbit.trees;

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

/**
 *  Solution:
  For two trees to be mirror images, the following three
  conditions must be true
  1 - Their root node's key must be same
  2 - left subtree of left tree and right subtree
       of right tree have to be mirror images
  3 - right subtree of left tree and left subtree
       of right tree have to be mirror images

 *
 */
class TreeNodeSymmetric {
    int val;
    TreeNodeSymmetric left;
    TreeNodeSymmetric right;

    TreeNodeSymmetric(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class SymmetricBinaryTree {
    public int isSymmetric(TreeNodeSymmetric A, TreeNodeSymmetric B) {
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
