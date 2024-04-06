package dynamic;

import java.util.Arrays;

public class leetcode674 {

    public int findLengthOfLCIS(int[] nums) {
        return dp(nums);
    }
    public int Force(int[] nums) {
        int max = 0; // 记录最长递增子序列的长度

        for (int i = 0; i < nums.length; i++) {
            int index = i + 1;
            // 找出以当前元素为起点的最长递增子序列的长度
            while (index < nums.length && nums[index] > nums[index - 1]) {
                index++;
            }
            // 更新最长递增子序列的长度【最大值】
            max = Math.max(max, index - i);
        }

        return max;
    }

    public int dp(int[] nums) {
        // 初始化动态规划数组，并将所有元素初始化为1，代表最短的连续递增子序列长度至少为1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1; // 记录最大连续递增子序列的长度

        // 遍历数组，从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素大于前一个元素，则表示可以将当前元素加入到前一个连续递增子序列中
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1; // 更新并且记录
            }
            // 取最大连续递增子序列长度的最大值
            res = Math.max(res, dp[i]);
        }
        return res; // 返回最大连续递增子序列的长度
    }


}
