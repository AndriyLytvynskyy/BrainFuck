package com.booking.binary;

import java.net.URLClassLoader;

/**
 * Created by Andrii_Lytvynskyi on 6/30/2015.
 */
public class SimpleBitManipulations {
    public static void main(String[] args) {
        int i = 1;
        System.out.println(i | (i + 1));
        System.out.println(i & (i + 1));
        System.out.println((i + 1) & i);
        System.out.println((i + 1) ^ i);

        int a = 60;
        int b = 13;
        System.out.println(a | b);

        System.out.println(checkIfNPow2(10));
    }


    public static boolean checkIfNPow2(int n) {
        if (n % 2 == 0) {
            return checkIfNPow2(n / 2);
        } else {
            if (n != 1) {
                return false;
            }
        }
        return true;

    }
}
