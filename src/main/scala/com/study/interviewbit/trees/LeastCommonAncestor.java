package com.study.interviewbit.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 *
 *  Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node
 *  that has both v and w as descendants.
 *
 *  https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class LeastCommonAncestor {

    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    private int findLCAInternal(TreeNode root, int n1, int n2) {

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    private boolean findPath(TreeNode root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.val == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    public int lca(TreeNode A, int B, int C) {
        path1.clear();
        path2.clear();
        return findLCAInternal(A, B, C);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);

        TreeNode node1_left = new TreeNode(5);
        A.left = node1_left;
        node1_left.left = new TreeNode(6);
        TreeNode node1_left_right = new TreeNode(2);
        node1_left.right = node1_left_right;

        node1_left_right.left = new TreeNode(7);
        node1_left_right.right = new TreeNode(4);


        TreeNode node2_right = new TreeNode(1);
        A.right = node2_right;
        node2_right.left = new TreeNode(0);
        node2_right.right = new TreeNode(8);

        System.out.println(new LeastCommonAncestor().lca(A, 5, 1));

    }


}
