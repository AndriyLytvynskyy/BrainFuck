package com.study.trees;
/** 4.1
 Implement a function to check if a binary tree is balanced. For the purposes of this
 question, a balanced tree is defined to be a tree such that the heights of the two
 subtrees of any node never differ by more than one.
 */

// for each node, the two subtrees differ in height by no more than one

// The "height" of a node in a binary tree is the length of longest path from that node to a leaf.

//                  A  (Height = 2)
//             /              \
//        (height =-1)        B (Height = 1) <-- Unbalanced because 1-(-1)=2 >1
//                            \
//                    C (Height = 0)


/**
 *        A (h=3)
 *      /         \
 *   B(h=1)      C (h=2)
 *   /            /   \
 * D (h=0)     E(h=0)  F (h=1)
 *  /
 *  G (h=0)
 */
public class TreeIsBalanced {
    static class TreeNode {
        TreeNode left;
        TreeNode right;

        private final String name;

        TreeNode(String name) {
            this.name = name;
        }
    }

    //------------------------------
    public static int getHeight(TreeNode root) {
        if (root == null) return 0; // Base case
        return Math.max(getHeight(root.left),
                getHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true; // Base case
        int heightDiff =
                getHeight(root.left) -
                        getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else { // Recurse
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
//--------------------------------------

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0; // Height of 0
        }

         /* Check if left is balanced. */
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1; // Not balanced
        }
         /* Check if right is balanced. */
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1; // Not balanced
        }

         /* Check if current node is balanced. */
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1; // Not balanced
        } else {
             /* Return height */
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced2(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode("A");
        TreeNode treeNodeB = new TreeNode("B");
        tree.right = treeNodeB;
        TreeNode treeNodeC = new TreeNode("C");
        treeNodeB.right =  treeNodeC;

        System.out.println(getHeight(tree));

    }

}
