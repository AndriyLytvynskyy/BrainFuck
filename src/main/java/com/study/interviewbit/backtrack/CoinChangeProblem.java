package com.study.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.List;

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

    public static void changeMe(List<Integer> list, Integer x, int[] y){
        list.add(5);
        x++;
        y[0] = 125;
        System.out.println(y[0]);
//        System.out.println(x);
//        System.out.println(list.get(0));

    }

    public static void main(String[] args) {
        //System.out.println(combination(4, 0));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Integer x = 10;
        int[]y = new int[]{0,1};
        changeMe(list, x, y);
        System.out.println(y[0]);
        //System.out.println(combinationIterative());
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
