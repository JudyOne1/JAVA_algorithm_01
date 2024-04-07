package dynamic;

import java.util.Arrays;

public class leetcode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return dp(nums1, nums2);
    }

    public int dp(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 初始化动态规划数组，尺寸为(m+1) x (n+1)，避免边界条件判断
        int dp[][] = new int[m + 1][n + 1];
        // 填充动态规划数组
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                // 根据当前元素是否相等，应用动态规划递推公式
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果当前元素不相等，则最长公共子序列的长度为两种情况的最大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
        // 返回最长公共子序列的长度
        return dp[m][n];
    }

    public static void main(String[] args) {
        new leetcode1035().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4});
        new leetcode1035().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2});
    }
}
