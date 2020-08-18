package com.study.leet;

/**
 * @author andrii_lytvynskyi
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = 121;
        int rev = 0;
        int temp = x;
        while (x !=0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        System.out.println(rev);
        System.out.println(temp);
        System.out.println(rev != x);
    }
}
