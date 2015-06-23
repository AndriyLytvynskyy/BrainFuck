package com.booking.trees;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
    to create a binary search tree with minimal height.
 */
/*
The algorithm is as follows:
        1. Insert into the tree the middle element of the array.
        2. Insert (into the left subtree) the left subarray elements.
        3. Insert (into the right subtree) the right subarray elements.
        4. Recurse.
        The code below implements this algorithm.
        1 TreeNode createMinimalBST(int arr[], int start, int end) {
        2 if (end < start) {
        3    return null;
        4 }
        int mid = (start + end) / 2;
        6  TreeNode n = new TreeNode(arr[mid]);
           n.left = createMinimalBST(arrj start, mid - 1);
        8  n.right = createMinima!BST(arr, mid + 1, end);
        9  return n;
        10 }
        11
        12 TreeNode createMinimalBST(int array[]) {
        13   return createMinimalBST(array, <d, array.length - 1);
        14 }
*/
public class BSTWithMinimalHeight {




}
