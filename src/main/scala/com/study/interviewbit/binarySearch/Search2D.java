package com.study.interviewbit.binarySearch;

import java.util.ArrayList;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than or equal to the last integer of the previous row.
 Example:

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return 1 ( 1 corresponds to true )

 Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 *
 *
 */
public class Search2D {
    public int binarySearch(ArrayList<Integer> a, int n, int b){
        int low = 0;
        int high = n-1;
        while (low <=high){
            int mid = (low + high)/2;
            if (b < a.get(mid)){
                high = mid -1;
            } else if (b > a.get(mid)){
                low = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        for (int i = 0; i< a.size();i++){
            int lastElement = a.get(i).get(a.get(i).size()-1);
            int firstElement = a.get(i).get(0);
            if ((b == lastElement) || (b == firstElement)){
                return 1;
            }
            if ((b<lastElement) && (b > firstElement)){
                return (binarySearch(a.get(i), a.get(i).size(), b) == -1?0:1);
                //return 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {


    }
}
