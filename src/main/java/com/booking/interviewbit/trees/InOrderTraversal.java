package com.booking.interviewbit.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 * 1
    \
    2
    /
   3
 *
 *  [1,3,2]
 *
 *  Morris Traversal algorithm:
 *  http://www.learn4master.com/algorithms/morris-traversal-inorder-tree-traversal-without-recursion-and-without-stack
 *  https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 *
 *  MorisTraversal gives good space complexity O(1), while traversal using stack or recursion is O(h),
 *  where h = depth of the tree
 *
 */
public class InOrderTraversal {

    public static int[] inorderTraversal(TreeNode A) {
        List<Integer> indexes = new ArrayList<>();
        TreeNode cur = A;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);  // if there is no left child, visit current node
                indexes.add(cur.val);
                cur = cur.right;  // then we go the right branch
            } else {
                // find the right most leaf of root.left node.
                TreeNode pre = cur.left;
                // when pre.right == null, it means we go to the right most leaf
                // when pre.right == cur, it means the right most leaf has been visited in the last round
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // this means the pre.right has been set, it's time to go to current node
                if (pre.right == cur) {
                    pre.right = null;
                    // means the current node is pointed by left right most child
                    // the left branch has been visited, it's time to print the current node
                    System.out.println("from left right most--" + cur.val);
                    indexes.add(cur.val);
                    cur = cur.right;
                } else {
                    // the fist time to visit the pre node, make its right child point to current node
                    pre.right = cur;
                    System.out.println("----set pre for cur=" + cur.val);
                    cur = cur.left;
                }
            }
        }
        int[] ret = new int[indexes.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = indexes.get(i);
        }
        return ret;

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
        int[] indexes = inorderTraversal(testCase2());
        System.out.println(indexes);

    }
}
