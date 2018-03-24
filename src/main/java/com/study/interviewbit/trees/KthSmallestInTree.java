package com.study.interviewbit.trees;

import java.util.Stack;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 *
 *
 */
public class KthSmallestInTree {
    public static int getHeight(TreeNode root) {
        if (root == null) return 0; // Base case
        return Math.max(getHeight(root.left),
                getHeight(root.right)) + 1;
    }
    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int result = 0;
        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0) {
                    result = t.val;
                }
                p = t.right;
            }
        }
        return result;
    }
public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.pop());

    TreeNode treeNodeIdent = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    treeNodeIdent.left = left;
    treeNodeIdent.right = right;

//    TreeNode treeNodeIdent1 = new TreeNode(1);
//    TreeNode left1 = new TreeNode(3);
//    TreeNode right1 = new TreeNode(2);
//    treeNodeIdent1.left = left1;
//    treeNodeIdent1.right = right1;
    //System.out.println(getHeight(treeNodeIdent));
     System.out.println(new KthSmallestInTree().kthsmallest(treeNodeIdent, 2));
}
}
