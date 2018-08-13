package com.study.trees;

/**
 * 4.5 Implement a function to check if a binary tree is a binary search tree.
 *
 */

/**
 * In computer science, a binary search tree (BST) is a binary tree which has the following properties:
 * <p/>
 * Each node has a value.
 * A total order is defined on these values.
 * The left subtree of a node contains only values less than or equal to the node's value.
 * The right subtree of a node contains only values greater than or equal to the node's value.
 */
public class BinaryIsASearchBinaryTree {
    class TreeNode {
        TreeNode right;
        TreeNode left;
        int data;

    }

    public static int last_printed = Integer.MIN_VALUE;

    public static boolean checkBST(TreeNode n) {
        if (n == null) return true;
        // Check / recurse left
        if (!checkBST(n.left)) return false;

        // Check current
        if (n.data <= last_printed) return false;
        last_printed = n.data;

        // Check / recurse right
        if (!checkBST(n.right)) return false;

        return true; // All good!
    }
}
