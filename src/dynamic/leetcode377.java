package dynamic;

public class leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        return process(nums, target, 0);
    }

    public static int process(int[] nums, int target, int index) {
        if (target == 0)
            return 1;
        if (index == nums.length)
            return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0)
                res += process(nums, target - nums[i], i);
        }
        return res;
    }
    public int dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int target = 35;
        System.out.println(process(nums, target, 0));
    }


}
