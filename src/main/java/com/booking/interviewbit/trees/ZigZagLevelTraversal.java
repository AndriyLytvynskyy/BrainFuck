package com.booking.interviewbit.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 *   3
 * / \
 * 9  20
     /  \
    15   7
 * <p>
 * Result:
 * [
 * [3],
 * [20, 9],
 * [15, 7]
 * ]
 *
 *
 *
 * Solution discussion:
 * remember that stack is a LIFO structure. Both insertion and deletion are allowed at only one end of Stack called Top
 *
 *
 *
 */

// Definition for binary tree
class TreeNodeZig {
    int val;
    TreeNodeZig left;
    TreeNodeZig right;

    TreeNodeZig(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class ZigZagLevelTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNodeZig A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return result;
        }
        // Create a general stack
        Stack<TreeNodeZig> stack = new Stack<TreeNodeZig>();
        stack.push(A);
        boolean flipDirection = false;

        while (!stack.isEmpty()) {
            // Create a helper stack
            Stack<TreeNodeZig> helperStack = new Stack<TreeNodeZig>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                TreeNodeZig pop = stack.pop();
                list.add(pop.val);
                if (!flipDirection) {
                    if (pop.left != null) {
                        helperStack.push(pop.left);
                    }
                    if (pop.right != null) {
                        helperStack.push(pop.right);
                    }
                } else {
                    if (pop.right != null) {
                        helperStack.push(pop.right);
                    }
                    if (pop.left != null){
                        helperStack.push(pop.left);
                    }
                }
            }
            flipDirection = !flipDirection;
            result.add(list);
            stack = helperStack;
        }
        return result;


    }

    public static void main(String[] args) {
        TreeNodeZig treeNodeZig1 = new TreeNodeZig(3);
        TreeNodeZig treeNodeZig2 = new TreeNodeZig(20);
        TreeNodeZig treeNodeZig3 = new TreeNodeZig(9);
        treeNodeZig1.left = treeNodeZig2;
        treeNodeZig1.right = treeNodeZig3;

        TreeNodeZig treeNodeZig4 = new TreeNodeZig(7);
        TreeNodeZig treeNodeZig5 = new TreeNodeZig(15);
        treeNodeZig2.left = treeNodeZig4;
        treeNodeZig2.right = treeNodeZig5;

        ArrayList<ArrayList<Integer>> result = new ZigZagLevelTraversal().zigzagLevelOrder(treeNodeZig1);
        System.out.println(result);

    }

}
