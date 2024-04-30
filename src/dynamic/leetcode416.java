package dynamic;

import java.lang.annotation.Target;
import java.util.Arrays;

public class leetcode416 {
    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if (target % 2 != 0) {
            return false;
        }
        target /= 2;
        return process(nums, target, 0);
    }

    //超出时间限制
    public boolean process(int[] nums, int target, int index) {
        if (index >= nums.length) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (nums[index] == target){
            return true;
        }
        boolean p2 = process(nums, target, index + 1);
        boolean p1 = process(nums, target - nums[index], index + 1);

        return p1 || p2;
    }

    public boolean dp(int[] nums,int target) {

        boolean[][] dp = new boolean[nums.length][target + 1];
        // 初始化动态规划数组，第 0 行表示不选取任何元素的情况
        // 填表格第一行，取下标的时候要防止下标越界，所以要判断一下。
        // 如果当前元素小于背包容量，则表示可以放入背包，所以 dp[0][nums[0]] = true
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 动态规划遍历，逐个考虑数组中的元素是否放入背包
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 当前元素小于背包容量时，考虑放入或不放入当前元素
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    // 当前元素大于等于背包容量时，只能考虑不放入当前元素
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 返回是否可达目标和
        return dp[nums.length-1][target];
    }


}
