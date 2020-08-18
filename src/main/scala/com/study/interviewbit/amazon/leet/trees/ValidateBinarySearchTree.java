package com.study.interviewbit.amazon.leet.trees;

/**
 * @author andrii_lytvynskyi
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (null != root) {
            int rootRight = root.right == null ? 0 : root.right.val;
            int rootLeft = root.left == null ? 0 : root.left.val;
            if ((root.val < rootRight) && (root.val > rootLeft)) {
                return isValidBST(root.right) && isValidBST(root.left);
            } else {
                return false;
            }

        }
        return true;


    }
}
