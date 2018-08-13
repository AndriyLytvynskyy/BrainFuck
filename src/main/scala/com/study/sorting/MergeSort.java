package com.study.sorting;

/**
 * Created by Andrii_Lytvynskyi on 6/23/2015.
 */
public class MergeSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length);
    }

    // Sort a[lo, hi).
    public static void sort(Comparable[] a, int lo, int hi) {
        int N = hi - lo;        // number of elements to sort

        // 0- or 1-element file, so we're done
        if (N <= 1) return;

        // recursively sort left and right halves
        int mid = lo + N / 2;
        sort(a, lo, mid);
        sort(a, mid, hi);

        // merge two sorted subarrays
        Comparable[] aux = new Comparable[N];
        int i = lo, j = mid;
        for (int k = 0; k < N; k++) {
            if (i == mid) {
                aux[k] = a[j++];
            } else {
                if (j == hi) {
                    aux[k] = a[i++];
                } else if (a[j].compareTo(a[i]) < 0) {
                    aux[k] = a[j++];
                } else {
                    aux[k] = a[i++];
                }
            }
        }

        // copy back
        for (int k = 0; k < N; k++) {
            a[lo + k] = aux[k];
        }
    }


    /**
     * ********************************************************************
     * Check if array is sorted - useful for debugging
     * *********************************************************************
     */
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        return true;
    }

    /**
     * ********************************************************************
     * Show results
     * *********************************************************************
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }


    public static void main(String[] args) {
        String[] a = new String[]{"A", "B", "C", "D"};
        MergeSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
