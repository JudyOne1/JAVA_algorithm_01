package dynamic;

import java.util.Arrays;

public class leetcode300 {

    public int lengthOfLIS5(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }


    public int lengthOfLIS4(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //i可以放在j后面，那么i的长度就是j的长度+1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }


    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i] + 1);
        }
        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        //从后往前找比自己小的数
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(nums, i));
        }
        return ans;
    }

    private int dp1(int[] nums) {
        int n = nums.length, ans = 0; // n为数组长度，ans用于存储最大连续元素个数
        int[] dp = new int[n]; // dp数组用于存储以每个元素结尾的最长递增子序列长度

        for (int i = 0; i < n; i++) {
            // 遍历每个元素，计算以该元素为结尾的最长递增子序列长度
            for (int j = 0; j < i; j++) {
                // 比较当前元素与之前元素，若当前元素大，则更新dp[i]
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大连续元素个数
            ans = Math.max(ans, ++dp[i]);
        }

        return ans; // 返回最大连续元素个数
    }


    private int dfs(int[] nums, int i) {
        int max = 0; // 存储在当前索引之前的最大连续递增子序列长度

        // 遍历当前索引之前的所有元素
        for (int j = 0; j < i; j++) {
            // 如果前一个元素小于当前元素，则进行DFS递归调用
            if (nums[j] < nums[i]) {
                max = Math.max(max, dfs(nums, j)); // 更新最大长度
            }
        }

        return max + 1; // 返回最大长度加上当前元素，即当前索引处的最大连续递增子序列长度
    }

    public int lengthOfLIS(int[] nums) {
        return process(nums, 0, -1);
    }

    /**
     * 处理给定数组并寻找最长上升子序列。
     *
     * @param nums  给定的整数数组。
     * @param index 当前处理的数组索引。
     * @param pre   上一个处理的元素索引。
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

    public int dp(int[] nums) {
        // 初始化dp数组，dp[i]表示以nums[i]为结尾的最长连续递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 将dp数组初始化为1，因为每个单独的元素都可以看作是一个长度为1的递增子序列

        // 遍历数组，更新dp数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果nums[i]大于nums[j]，则可以将nums[i]接在nums[j]后的递增子序列上
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 更新dp[i]的值为当前最大长度
                }
            }
        }

        // 返回dp数组中的最大值，即最长连续递增子序列的长度
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        new leetcode300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }

}
