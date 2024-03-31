package dynamic;

public class leetcode746 {

    public int minCostClimbingStairs(int[] cost) {
        // 返回爬到最后两个台阶的最小花费和爬到最后一个台阶的最小花费中的较小值
        return Math.min(process(cost, cost.length - 1), process(cost, cost.length - 2));
    }


    public int process(int[] cost, int n) {
        // 如果目标台阶是第一个或第二个，直接返回该台阶的花费
        if(n == 0)
            return cost[0];
        if(n == 1)
            return cost[1];
        // 递归计算到达前一个台阶和前两个台阶的最小花费，然后加上当前台阶的花费，返回较小值
        return Math.min(process(cost, n - 1), process(cost, n - 2)) + cost[n];
    }
    public int dp(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        // 初始化dp数组
        dp[0] = cost[0];
        dp[1] = cost[1];
        // 遍历计算到达每个台阶的最小花费
        for(int i = 2; i < n; i++)
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        // 返回到达最后一个台阶的最小花费
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
