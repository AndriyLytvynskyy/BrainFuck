package com.booking.interviewbit.trees;

import java.util.*;

/**
 *
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 * 1
    \
    2
    /
   3
 *
 *  [3,2,1]
 *
 *  Morris Traversal algorithm:
 *  http://www.learn4master.com/algorithms/morris-traversal-inorder-tree-traversal-without-recursion-and-without-stack
 *  https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 *
 *  MorisTraversal gives good space complexity O(1), while traversal using stack or recursion is O(h),
 *  where h = depth of the tree
 *
 */
public class PostOrderTraversal {

    private static void postOrder(TreeNode root, ArrayList<Integer> out) {
        // Create two stacks
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        if (root == null)
            return;

        // push root to first stack
        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty())
        {
            // Pop an item from s1 and push it to s2
            TreeNode temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {

            TreeNode temp = s2.pop();
            out.add(temp.val);
        }

    }

    public static int[] postOrderTraversalStack(TreeNode a) {
        ArrayList<Integer> out = new ArrayList<>();
        postOrder(a, out);
        int [] indexes = new int[out.size()];
        int i = 0;
        for (int index : out) {
            indexes[i++] = index;
        }
        return indexes;
    }

    /**
     * 1
     *  \
     *   2
     *  /
     * 3
     */
    public static TreeNode testCase1(){
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        tree1.right = tree2;
        tree2.left = new TreeNode(3);
        return tree1;
    }

    /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
    */
    public static TreeNode testCase2(){
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        tree1.left = tree2;
        tree1.right = new TreeNode(3);
        tree2.left = new TreeNode(4);
        tree2.right = new TreeNode(5);
        return tree1;
    }

    public static void main(String[] args) {
        int[] indexes = postOrderTraversalStack(testCase1());
        System.out.println(indexes);

    }
}
