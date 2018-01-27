package com.booking.interviewbit.trees;


/**
 * Given a binary tree, determine if it is height-balanced.
 *
 */
 //for each node, the two subtrees differ in height by no more than one

// The "height" of a node in a binary tree is the length of longest path from that node to a leaf.

//                  A  (Height = 2)
//             /              \
//        (height =-1)        B (Height = 1) <-- Unbalanced because 1-(-1)=2 >1
//                            \
//                    C (Height = 0)


public class BalancedBinaryTree {
    public static int getHeight(TreeNode root) {
        if (root == null) return 0; // Base case
        return Math.max(getHeight(root.left),
                getHeight(root.right)) + 1;
    }

    public static int isBalancedFunc(TreeNode root) {
        if (root == null) return 1; // Base case
        int heightDiff =
                getHeight(root.left) -
                        getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return 0;
        } else { // Recurse
            return isBalancedFunc(root.left) * isBalancedFunc(root.right);
        }
    }
      public int isBalanced(TreeNode A) {
           return isBalancedFunc(A);
    }
}
