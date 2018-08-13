package com.study.interviewbit.trees;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node’s key.
 The right subtree of a node contains only nodes with keys greater than the node’s key.
 Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 */
public class ValidBinarySearchTree {
    public boolean checkBST1(TreeNode root, Integer min, Integer max){
        if (root == null){
            return true;
        }
        if ((root.val > min) && (root.val < max) &&
                checkBST1(root.left, min, root.val) &&
                checkBST1(root.right, root.val, max)){
            return true;
        } else return false;

    }

    public int last_printed = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode n) {
        if (n == null) return true;
        // Check / recurse left
        if (!checkBST(n.left)) return false;

        // Check current
        if (n.val <= last_printed) return false;
        last_printed = n.val;

        // Check / recurse right
        if (!checkBST(n.right)) return false;

        return true; // All good!kkke
    }
    public int isValidBST(TreeNode A) {
        return checkBST1(A, Integer.MIN_VALUE, Integer.MAX_VALUE)?1:0;
    }
}
