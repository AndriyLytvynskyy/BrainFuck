package com.study.trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 4.4
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class BinaryTreeWithLinkedList {

    class TreeNode {
        TreeNode left;
        TreeNode right;
    }

    void createLevelLinkedList(TreeNode root,
                               ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return; // base case

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<TreeNode>();
            /* Levels are always traversed in order. So., if this is the
            * first time we've visited level i, we must have seen levels
            10 * 0 through i - 1. We can therefore safely add the level at
            II * the end. */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);

        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(
            TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists =
                new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }


    ArrayList<LinkedList<TreeNode>> createLevelLinkedListNoRecursion(
            TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result =
                new ArrayList<LinkedList<TreeNode>>();
         /* "Visit" the root */
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                 /* Visit the children */
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
