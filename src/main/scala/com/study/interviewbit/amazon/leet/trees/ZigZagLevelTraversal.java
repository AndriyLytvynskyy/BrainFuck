package com.study.interviewbit.amazon.leet.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode A) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (A == null) {
            return result;
        }
        // Create a general stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(A);
        boolean flipDirection = false;

        while (!stack.isEmpty()) {
            // Create a helper stack
            Stack<TreeNode> helperStack = new Stack<TreeNode>();
            LinkedList l = new LinkedList();

            ArrayList<Integer> list = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if (!flipDirection) {
                    if (pop.left != null) {
                        helperStack.push(pop.left);
                    }
                    if (pop.right != null) {
                        helperStack.push(pop.right);
                    }
                }
                else {
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
       TreeNode treeNodeZig1 = new TreeNode(3);
       TreeNode treeNodeZig2 = new TreeNode(20);
       TreeNode treeNodeZig3 = new TreeNode(9);
        treeNodeZig1.left = treeNodeZig2;
        treeNodeZig1.right = treeNodeZig3;

       TreeNode treeNodeZig4 = new TreeNode(7);
       TreeNode treeNodeZig5 = new TreeNode(15);
        treeNodeZig2.left = treeNodeZig4;
        treeNodeZig2.right = treeNodeZig5;

        List<List<Integer>> result = new ZigZagLevelTraversal().zigzagLevelOrder(treeNodeZig1);
        System.out.println(result);

    }

}
