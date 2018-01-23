package com.booking.interviewbit.trees;

import java.util.ArrayList;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 *
 *  Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree
 *
 *  Solution to the problem can be found here:
 *  https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 */
public class InOrderTraversalOfCartesian {

    TreeNode root;
    TreeNode buildTree(Integer inorder[], int start, int end, TreeNode node) {

        if (start > end)
            return null;

        /* Find index of the maximum element from Binary Tree */
        int i = max(inorder, start, end);

        /* Pick the maximum value and make it root */
        node = new TreeNode(inorder[i]);

        /* If this is the only element in inorder[start..end],
         then return it */
        if (start == end)
            return node;

        /* Using index in Inorder traversal, construct left and
         right subtrees */
        node.left = buildTree(inorder, start, i - 1, node.left);
        node.right = buildTree(inorder, i + 1, end, node.right);

        return node;
    }

    private int max(Integer arr[], int strt, int end) {

        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
           Integer[] arr = A.toArray(new Integer[A.size()]);
           return buildTree(arr, 0, arr.length -1, root);
    }
}
