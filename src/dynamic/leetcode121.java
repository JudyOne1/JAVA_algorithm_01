package dynamic;

public class leetcode121 {
    public int maxProfit(int[] prices) {
        // 初始化买入成本为最大整数，利润为0
        int cost = Integer.MAX_VALUE, profit = 0;
        // 遍历每一天的价格
        for (int price : prices) {
            // 更新买入成本为当前价格和之前买入成本的较小值
            cost = Math.min(cost, price);
            // 更新利润为当前价格减去买入成本和之前利润的较大值
            profit = Math.max(profit, price - cost);
        }
        return profit;
// 旧算法：使用双重循环遍历所有可能的买入和卖出组合，然后计算利润
// int max = 0;
// for (int i = 0; i < prices.length; i++) {
//     for (int j = i + 1; j < prices.length; j++) {
//         if (prices[j] > prices[i]) {
//             max = Math.max(max, prices[j] - prices[i]);
//         }
//     }
// }
// return max;
    }
}
