package com.study.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author andrii_lytvynskyi
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) return true;
        if (root == null || root1 == null) return false;

        return root.val == root1.val && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);

    }

    public boolean isSymmetricIter(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll(); //retrieve and remove head
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
