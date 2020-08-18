package com.study.interviewbit.amazon.leet.strings;

/**
 * @author andrii_lytvynskyi
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        //transpose matrix
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = i; j < matrix.length;j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length/2;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }


    }
}
