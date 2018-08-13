package com.study.interviewbit.trees;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Given A : [1, 2, 3]
    A height balanced BST  :
       2
     /   \
    1     3
 *
 */
public class SortedArrayToBalanced {
    TreeNode sortedArrayToBST(List<Integer> arr, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr.get(mid));

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return sortedArrayToBST(a, 0, a.size()-1);

    }


    public static void main(String[] args) {


    }
}
