package dynamic;

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

    public boolean dp(int[] nums) {
        int target = Arrays.stream(nums).sum();
        // 如果数组总和为奇数，无法分割成两个相等和的子集
        if (target % 2 != 0) {
            return false;
        }

        target /= 2; // 目标和为总和的一半

        boolean[][] dp = new boolean[nums.length][target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            //在不选取任何元素的情况下，目标值可以被恰好装满。
            dp[0][nums[0]] = true;
        }

        //外层遍历物品
        for (int i = 1; i < nums.length; i++) {
            //内层遍历背包
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                //如果某个物品单独的重量恰好就等于背包的重量，那么也是满足dp数组的定义的
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                //如果某个物品的重量小于j，那就可以看该物品是否放入背包
                //dp[i - 1][j]表示该物品不放入背包，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
                //dp[i - 1][j - nums[i]]表示该物品放入背包。如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        // 返回是否可以达到目标和
        return dp[nums.length-1][target];
    }


}
