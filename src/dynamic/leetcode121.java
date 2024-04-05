package dynamic;

public class leetcode121 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] > prices[i]) {
//                    max = Math.max(max, prices[j] - prices[i]);
//                }
//            }
//        }
//        return max;
    }
}
