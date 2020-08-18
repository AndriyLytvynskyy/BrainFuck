package com.study.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andrii_lytvynskyi
 * https://www.youtube.com/watch?v=LPFhl65R7ww&feature=youtu.be
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        for (int num1: nums1) {
            list.add(num1);
        }

        for (int num2: nums2) {
            list.add(num2);
        }

        java.util.Collections.sort(list);

        if (list.size() % 2 == 0){
            //even
            int sumOfMiddleElements = list.get(list.size() / 2) + list.get(list.size()/2 - 1);
            return sumOfMiddleElements / 2.0;
        } else {
            //odd
            return (double)list.get(list.size() / 2);

        }
    }

    public static void main(String[] args) {
        //System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
