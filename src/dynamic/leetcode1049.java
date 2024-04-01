package dynamic;

import java.util.Arrays;

public class leetcode1049 {
    /**
     * 尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。
     * 这样就跟416很像了
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int res = process(stones, sum / 2, sum, stones.length - 1);
        return Math.abs((sum - res) - res);
    }


    public int dp(int[] stones) {
        // 计算所有石头的总重量
        int sum = Arrays.stream(stones).sum();
        // 目标是找到一组石头，使它们的重量最接近sum的一半
        int target = sum / 2;
        // 创建动态规划数组，dp[i][j]表示前i个石头中，如何选择才能得到和为j的最大值
        int dp[][] = new int[stones.length][target + 1];

        // 初始化第一行，因为只能选择第一个石头时，能获取的最大和就是这个石头的重量
        for (int j = stones[0]; j <= target; j++) {
            dp[0][j] = stones[0];
        }

        // 动态规划填表
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                // 如果当前石头重量小于等于当前和的目标值，考虑选择这个石头
                if (j >= stones[i]) {
                    // 可以选择当前石头时，比较两种情况：不选和选
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    // 当前石头重量大于当前和的目标值，无法选择此石头
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // 返回最终结果，计算能获取的最接近石头总和一半的和
        return Math.abs((sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target]);
    }


    private int process(int[] stones, int target, int sum, int index) {
        // 如果已经考虑完所有石头，返回当前累积和
        if (index < 0) {
            return sum;
        }
        // 如果当前累积和已经小于等于目标和，返回当前累积和
        if (sum <= target) {
            return sum;
        }
        // 决策：选择拿当前石头或不拿
        int p1 = process(stones, target, sum - stones[index], index - 1); // 拿
        int p2 = process(stones, target, sum, index - 1); // 不拿

        // 一直不拿石头的情况，返回0，防止干扰结果
        if (p2 == Arrays.stream(stones).sum()) {
            return 0;
        }

        // 返回两种决策中最接近target的那个
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        new leetcode1049().lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
    }
}
