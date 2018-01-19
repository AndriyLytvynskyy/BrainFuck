package com.booking.interviewbit.trees;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 *   5
    / \
   4   8
  /   / \
 11  13  4
 / \      \
 7 2      1
 *
 * Nice solutions can be found here, I need to try solving using iterative algorithm
 *
 * https://www.programcreek.com/2013/01/leetcode-path-sum/
 *
 */

public class PathSum {

//    boolean haspathSum(TreeNode node, int sum)
//    {
//        if (node == null)
//            return (sum == 0);
//        else
//        {
//            boolean ans = false;
//
//            /* otherwise check both subtrees */
//            int subsum = sum - node.val;
//            if (subsum == 0 && node.left == null && node.right == null)
//                return true;
//            if (node.left != null)
//                ans = ans || haspathSum(node.left, subsum);
//            if (node.right != null)
//                ans = ans || haspathSum(node.right, subsum);
//            return ans;
//        }
//    }

    public boolean hasPathSum(TreeNode A, int B) {
        if (A == null) {
            return (B ==0);
        }
        int subsum = B - A.val;
        if (subsum == 0){
            return true;
        }
        return hasPathSum(A.right, subsum) || hasPathSum(A.left, subsum);
    }

//    public int hasPathSum(TreeNode A, int B) {
//        if (A == null) {
//            return 0;
//        }
//        int sum = 0;
//        return hasPathSum(A, B, sum);
//
//    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(8);
        TreeNode treeNode31 = new TreeNode(11);
        TreeNode treeNode32 = new TreeNode(13);
        TreeNode treeNode33 = new TreeNode(4);
        TreeNode treeNode41 = new TreeNode(7);
        TreeNode treeNode42 = new TreeNode(2);
        TreeNode treeNode43 = new TreeNode(1);
        treeNode1.left = treeNode22;
        treeNode1.right = treeNode21;
        treeNode21.right = treeNode31;
        treeNode22.right = treeNode32;
        treeNode22.left = treeNode33;
        treeNode33.left = treeNode43;
        treeNode31.right = treeNode41;
        treeNode31.left = treeNode42;


        System.out.println((new PathSum().hasPathSum(treeNode1, 22)));
    }
}
