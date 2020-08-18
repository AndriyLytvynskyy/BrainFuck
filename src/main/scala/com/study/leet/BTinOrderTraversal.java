package com.study.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Input: [1,null,2,3]
 * 1
 *  \
 *   2
 *  /
 * 3
 * <p>
 * Output: [1,3,2]
 * <p>
 * https://dev.to/javinpaul/how-to-implement-inorder-traversal-in-a-binary-search-tree-1787
 */
public class BTinOrderTraversal {

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorderTraversalRecursive(root, ls);
        return ls;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> ls) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, ls);
        ls.add(root.val);
        inorderTraversalRecursive(root.right, ls);
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorderTraversalRecursive(root, ls);
        return ls;
    }


}
