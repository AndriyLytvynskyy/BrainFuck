package com.booking.interviewbit.backtrack;

/**
 * Recursive solution: do until (amount - coin) = 0
 *
 * Iterative solution: similar, just remember that
 * coins:                       1 2
 * indexes ('i' below):         0 1 2 3 4
 * combinations:                1 1 1 1 1
 *
 */
public class CoinChangeProblem {
    public static int[] coins = {1, 2};
    public static int amount = 4;

    public static void main(String[] args) {
        //System.out.println(combination(4, 0));
        System.out.println(combinationIterative());
    }

    private static int combinationIterative() {
        int[] combs = new int[amount + 1];
        combs[0] = 1;
        for (int coin: coins) {
            for(int i = 1; i<combs.length;i++){
                if (i >= coin){
                    combs[i] += combs[i - coin];
                }
            }
//            for (int comb : combs) {
//                System.out.print(comb);
//            }
            System.out.println();


        }
        return combs[2];
    }

    private static int combination(int amount, int curCoin) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }

        int comb = 0;
        for (int coin = curCoin; coin < coins.length; coin++) {
            comb += combination(amount - coins[coin], coin);
        }
        return comb;
    }
}
