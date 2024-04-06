package dynamic;

import java.util.Arrays;

public class leetcode300 {
    public int lengthOfLIS(int[] nums) {
        return process(nums, 0, -1);
    }

    /**
     * 处理给定数组并寻找最长上升子序列。
     *
     * @param nums 给定的整数数组。
     * @param index 当前处理的数组索引。
     * @param pre 上一个处理的元素索引。
     */
    public int process(int[] nums, int index, int pre) {
        if (index == nums.length) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        //pre小于0是初始状态，继续往后判断
        //if条件满足说明是上升子序列，长度要+1
        if (pre < 0 || nums[pre] < nums[index]) {
            p1 = process(nums, index + 1, index) + 1;
        }
        //如果不满足可能是不满足上升子序列条件
        //也可能是 满足条件但主动放弃
        p2 = process(nums, index + 1, pre);
        return Math.max(p1, p2);

    }
    public int dp(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        new leetcode300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }

}
