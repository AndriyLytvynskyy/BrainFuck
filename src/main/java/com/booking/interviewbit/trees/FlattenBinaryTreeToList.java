package com.booking.interviewbit.trees;

import java.util.Stack;

/**
 *  Given a binary tree, flatten it to a linked list in-place.
 *
 *       1
        / \
       2   5
      / \   \
     3   4   6
 */
public class FlattenBinaryTreeToList {
    public static TreeNode flatten(TreeNode a) {
        //Go down through the left, when right is not null, push right to stack.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = a;

        while(p != null || !stack.empty()){

            if(p.right != null){
                stack.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }

            p = p.right;
        }
        return a;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.right = treeNode5;
        treeNode1.left = treeNode2;
        treeNode5.right = new TreeNode(6);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(4);

        flatten(treeNode1);

    }
}
