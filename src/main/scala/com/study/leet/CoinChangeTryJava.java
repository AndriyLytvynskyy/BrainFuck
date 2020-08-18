package com.study.leet;



import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author andrii_lytvynskyi
 */
public class CoinChangeTryJava {
    public static int change(int amount, int[] coins) {
        List<Integer> list = new ArrayList<Integer>();
        for (int currentInt : coins) {
            list.add(currentInt);
        }
        return coinChangeHelper(amount, list);
    }

    private static int coinChangeHelper(int amount, List<Integer> coins){
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || coins.isEmpty()){
            return 0;
        }

        int firstCoin = coinChangeHelper(amount - coins.get(0), coins);

        int restCoins = coinChangeHelper(amount, coins.subList(1, coins.size()));
        return firstCoin + restCoins;
    }

    public static void main(String[] args) {
        change(5, new int[]{1,2,3});
    }
}
