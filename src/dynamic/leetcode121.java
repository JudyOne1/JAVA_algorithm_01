package dynamic;

public class leetcode121 {
    /**
     * 若在前 i 天选择买入，若想达到最高利润，则一定选择价格最低的交易日买入。
     * 考虑根据此贪心思想，遍历价格列表 prices 并执行两步：
     * <p>
     * 由于初始值 i=0 ，为了序号对应，本文设从第 0 天开始；
     * <p>
     * 更新前 i 天的最低价格，即最低买入成本 cost；
     * 更新前 i 天的最高利润 profit ，即选择「前 i−1 天最高利润 profit 」和「
     * 第 i 天卖出的最高利润 price - cost 」中的最大值 ；
     */
    public int maxProfit2(int[] prices) {
        int cost = Integer.MAX_VALUE, money = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            money = Math.max(money, price - cost);
        }
        return money;
    }

    public int maxProfit1(int[] prices) {
        // 花费和利润
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

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
