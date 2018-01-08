package com.booking.hackerrank.arrays;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created by Andriy on 10/29/2017.
 */
public class LeftRotation {
       public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;//in.nextInt();
        int k = 4;//in.nextInt();
        int a[] = {1,2,3,4,5};
//        for(int a_i=0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }
        int rot_number=k;
        if (n<k){
            for(int i = 1; i<=k;i++ ) {
                int tmp = n * i;
                if ((k-tmp) == 0){
                    rot_number = 0;
                    break;
                } else {
                    if (abs(k - tmp) < n ){
                        rot_number = abs(k - tmp);
                        break;
                    }
                }
            }
        }
        if (rot_number!=0) {
            for (int i = 0; i < rot_number; i++) {
                int j, first_el;
                first_el = a[0];
                for (j = 0; j < n - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[j] = first_el;
            }

            for (int i : a) {
                System.out.print(i + " ");
            }
        }
    }
}
