package com.example.algorithm.dp;

/**
 * @Description : 剑指 Offer 63. 股票的最大利润
 * @Author : young
 * @Date : 2022-07-03 12:19
 * @Version : 1.0
 **/
public class Test07 {
    public int maxProfit(int[] prices) {

        // 首个利润为0
        int a = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            a = Math.max(a, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return a;
    }

    public static void main(String[] args) {
        Test07 test = new Test07();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
