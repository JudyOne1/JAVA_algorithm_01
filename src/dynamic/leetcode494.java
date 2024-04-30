package dynamic;

public class leetcode494 {
    /**
     * 假设加法的总和为x，那么减法对应的总和就是sum - x。
     * <p>
     * 所以我们要求的是 x - (sum - x) = target
     * <p>
     * x = (target + sum) / 2
     */
    public int findTargetSumWays1(int[] nums, int target) {
        for (int x : nums) {
            target += x;
        }
        if (target < 0 || target % 2 == 1) {
            return 0;
        }
        target /= 2;
        return dfs(nums, target, 0);

    }
    private int dp1(int[] nums, int target){
        // 初始化动态规划数组，dp[i][j]表示前i个数字中是否存在数字之和为j的子集。
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[nums.length][0] = 1; // 初始化dp[nums.length][0]为1，表示前i个数字中存在一个和为0的子集。

        // 从最后一个数字开始向前遍历。
        for (int i = nums.length - 1; i >= 0; i--) {
            // 对于当前数字，尝试将其包含在子集中和不包含在子集中两种情况分别进行考虑。
            for (int j = 0; j <= target; j++) {
                if (j - nums[i] >= 0) {
                    // 如果当前数字可以被包含在子集中，更新dp[i][j]为包含和不包含当前数字两种情况下的结果之和。
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j - nums[i]];
                } else {
                    // 如果当前数字不能被包含在子集中，则dp[i][j]的值取决于不包含当前数字的情况。
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        // 返回dp[0][target]，即是否存在一个和为目标值的子集。
        return dp[0][target];
        //dfs(nums, target, index + 1) + dfs(nums, target - nums[index], index + 1);
    }

    private int dfs(int[] nums, int target, int index) {
        // 当遍历到数组末尾时，检查是否达到目标和
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        // 如果当前数字使目标和变为负数，则跳过该数字，继续遍历下一个
        if (target - nums[index] < 0){
            return dfs(nums, target, index + 1);
        }
        // 递归调用：同时考虑使用当前数字和不使用当前数字两种情况
        return dfs(nums, target, index + 1) + dfs(nums, target - nums[index], index + 1);
    }

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