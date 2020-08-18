package com.study.interviewbit.amazon.leet.recursion;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author andrii_lytvynskyi
 */
public class MinNumberOfCoins {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return minCoinsH(coins, amount, new int[amount]);
    }

    static int minCoinsH(int coins[], int rem, int[] count) {
        if (rem == 0) return 0;
        if (rem < 0) return -1; //we have not found a combination
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = minCoinsH(coins, rem - coin, count);
            if (res >= 0 && res < min){  //always add coin if result is more or equal zero
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }



    public static void main(String[] args) {
        coinChange(new int[]{1,2,5}, 6);
    }


}
