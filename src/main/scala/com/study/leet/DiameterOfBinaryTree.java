package com.study.leet;

/**
 * https://www.youtube.com/watch?v=ey7DYc9OANo
 * @author andrii_lytvynskyi
 */
public class DiameterOfBinaryTree {
    int diameterOfBinaryTree(TreeNode root){
        if (root == null) {
            return 0;
        }
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            int lDiam = diameterOfBinaryTree(root.left);
            int rDiam = diameterOfBinaryTree(root.right);
            return Math.max(lHeight + rHeight + 2, Math.max(lDiam, rDiam));


    }
    int height(TreeNode node){
        if (node == null){
            return 0;

        }

        int rHeight = height(node.right);
        int lHeight = height(node.left);
        //if ()
        return Math.max(rHeight, lHeight) + 1;

    }
}
