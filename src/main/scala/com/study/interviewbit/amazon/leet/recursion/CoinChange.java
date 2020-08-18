package com.study.interviewbit.amazon.leet.recursion;

/**
 * @author andrii_lytvynskyi
 */
public class CoinChange {
    public static int change(int amount, int[] coins) {
        int[] coinsH = new int[amount + 1];
        return changeH(amount, 0, coins, coinsH);
    }
    private static int changeH(int amount, int coinIndex, int[]coins, int[] coinsH){
        if (amount == 0){
            return 1;
        }
        if (amount < 0){
            return 0;
        }
        int combs = 0;
        if (coinsH[amount] > 0) return coinsH[amount];
        for (int i = coinIndex; i < coins.length; i++){
            combs += changeH(amount - coins[i], i, coins, coinsH);
        }
        coinsH[coinIndex] = combs;

        return combs;
    }
    public static void main(String[] args) {
         change(5, new int[]{1,2,5})
         ;
    }

}
