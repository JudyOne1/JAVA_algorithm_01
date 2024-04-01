package dynamic;

public class leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        return process(nums, target, 0, 0);
    }

    public int process(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        return process(nums, target, sum - nums[index], index + 1) + process(nums, target, sum + nums[index], index + 1);
    }

    public int dp(int[] nums, int S) {
        // 求和的最大值
        int max = 1000;
        // 初始的数组的和不会超过1000，因此最大为1000，最小为-1000
        int[][] dp = new int[nums.length][max * 2 + 1];
        // 针对nums[0]，先求出第一步
        dp[0][nums[0] + max] = 1;
        dp[0][-nums[0] + max] += 1;
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -max; sum <= max; sum++) {
                // 如果上一步有求出和为sum，那么可以继续计算下一步
                if (dp[i - 1][sum + max] > 0) {
                    dp[i][nums[i] + sum + max] += dp[i - 1][sum + max];
                    dp[i][-nums[i] + sum + max] += dp[i - 1][sum + max];
                }
            }
        }

        return dp[nums.length - 1][S + max];
    }
}