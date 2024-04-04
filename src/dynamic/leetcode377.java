package dynamic;

public class leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        return process(nums, target, 0);
    }

    public static int process(int[] nums, int target, int index) {
        if (target == 0) // 如果目标和为0，则找到了一种组合方式
            return 1;
        if (index == nums.length) // 如果已经遍历完数组，但目标和还未达到，则没有找到组合方式
            return 0;
        int res = 0; // 初始化结果为0
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) // 当前数字可以减去目标和时，递归寻找剩余部分的组合
                res += process(nums, target - nums[i], i);
        }
        return res; // 返回所有组合数
    }
    public int dp(int[] nums, int target) {
        int[] dp = new int[target + 1]; // 创建一个动态规划数组，长度为target+1
        dp[0] = 1; // 初始化dp[0]为1，表示目标和为0时有一种组合方式
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) { // 当前数字nums[j]可以被选取
                    dp[i] += dp[i - nums[j]]; // 更新dp[i]的值，表示选取当前数字后的组合数
                }
            }
        }
        return dp[target]; // 返回目标和为target时的组合数
    }
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int target = 35;
    }


}
