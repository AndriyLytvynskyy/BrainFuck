package com.study.leet;

/**
 * @author andrii_lytvynskyi
 */
public class MaximumAverageTree {
    private static double max = Integer.MIN_VALUE;

    public static double maximumAverageSubtree(TreeNode root) {
        if (root == null){
            return 0.0;
        }
        double[] res = countSumPerNode(root);
        return res[2];
    }

    public static double [] countSumPerNode(TreeNode root){
        if (root == null) {
            return new double[]{0, 0, 0};
        }
        double [] rightNodeResults = countSumPerNode(root.right);
        double [] leftNodeResults  = countSumPerNode(root.left);
        double count = rightNodeResults[0] + leftNodeResults[0] + 1;
        double sum = rightNodeResults[1] + leftNodeResults[1] + root.val;
        double max = Math.max(rightNodeResults[2], leftNodeResults[2]);
        return new double[]{count, sum, Math.max(max, sum / count)};

    }

    public static void main(String[] args) {
        TreeNode x1 = new TreeNode(5);
        x1.right = new TreeNode(6);
        x1.left = new TreeNode(1);

        System.out.println(maximumAverageSubtree(x1));
    }


}
