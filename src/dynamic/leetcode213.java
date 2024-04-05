package dynamic;

import java.util.Arrays;

public class leetcode213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
//        int[] ints = Arrays.copyOfRange(nums, 0, nums.length - 1);
//        return Math.max(process(nums, 1), process(ints, 0));
        //arr0: 0到倒数第二 arr1: 1到倒数第一
        int[] arr0 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] arr1 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(dp(arr1), dp(arr0));

    }

    public int dp(int[] nums) {
        // 创建一个数组来保存到当前位置为止能抢到的最大金额。
        int[] dp = new int[nums.length];
        // 初始化前两个位置的最大金额。
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 从第三个位置开始遍历，计算每个位置能抢到的最大金额。
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        // 返回最后一个位置的最大金额。
        return dp[nums.length - 1];
    }

    public int process(int[] nums, int index) {
        // 如果到了最后一个，直接抢。
        if (index == nums.length - 1) {
            return nums[index];
        }
        // 如果位置超出了数组范围，返回0。
        if (index >= nums.length) {
            return 0;
        }
        int p1 = process(nums, index + 1);//不抢当前这家
        int p2 = process(nums, index + 2) + nums[index];//抢当前这家

        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        new leetcode213().rob(new int[]{1, 2, 3, 1});
    }
}
