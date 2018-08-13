package com.study.trees;

/**
 * 4.6.  Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree. You may assume that each node has a link to its parent.
 */
public class BSTFindSuccessor {
    static class TreeNode {
        TreeNode parent;
        TreeNode right;
        TreeNode left;
        final int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null;
/* Found right children -> return leftmost node of right
5 * subtree. */
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            // Go up until we're on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
