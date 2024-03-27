package Greedy;

public class leetcode122 {
    public int maxProfit(int[] prices) {
        //把利润分解为每天为单位的维度，把每天的正利润加起来
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
