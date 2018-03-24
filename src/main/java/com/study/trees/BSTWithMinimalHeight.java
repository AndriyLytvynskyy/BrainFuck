package com.study.trees;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
/*
4.3
The algorithm is as follows:
        1. Insert into the tree the middle element of the array.
        2. Insert (into the left subtree) the left subarray elements.
        3. Insert (into the right subtree) the right subarray elements.
        4. Recurse.


*/
public class BSTWithMinimalHeight {

    static class TreeNode {
        TreeNode right;
        TreeNode left;
        final int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static TreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

    static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        TreeNode tree = createMinimalBST(arr);

        System.out.println(tree);
    }
}


