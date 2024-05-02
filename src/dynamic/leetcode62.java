package dynamic;

public class leetcode62 {
    public int uniquePaths1(int m, int n) {
        return dfs(m, n);
    }

    private int dp1(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // 创建一个(m+1)行(n+1)列的二维数组，用于存储动态规划的结果

        // 初始化第一行和第一列的值为1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    // 核心递推公式：dfs(m, n) = dfs(m - 1, n) + dfs(m, n - 1);
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];  // 返回最终结果
    }

    private int dfs(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return dfs(m - 1, n) + dfs(m, n - 1);
    }

    public int uniquePaths(int m, int n) {
        return process(m, n);
    }

    public int dp(int m, int n) {
        // 当m或n有一个为1时，表示只有一行或一列，只有一种选择，故返回1
        if (m == 1 || n == 1)
            return 1;
        int dp[][] = new int[m + 1][n + 1];

        // 动态规划填表过程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 初始化边界条件
                if (i == 1 || j == 1)
                    dp[i][j] = 1;
                else
                    // 状态转移方程，当前值等于左边加右边的和
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回最终结果
        return dp[m][n];
    }

    public int process(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return process(m - 1, n) + process(m, n - 1);
    }


}
