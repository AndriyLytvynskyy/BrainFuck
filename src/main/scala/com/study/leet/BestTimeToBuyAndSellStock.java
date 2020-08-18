package com.study.leet;

/**
 * @author andrii_lytvynskyi
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //trick with 2 variables - max profit and min profit
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;

    }
}
