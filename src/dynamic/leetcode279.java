package dynamic;

import java.util.Arrays;

public class leetcode279 {
    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
     * 其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     */
    public int numSquares2(int n) {
//        return dfs2(n);
        return dp2(n);
    }

    private int dp2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    private int dfs2(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 1; i * i <= n; i++) {
            int next = dfs(n - i * i) + 1;
            ans = Math.min(next, ans);
        }
        return ans;

    }


    public int numSquares1(int n) {
        return dfs(n);
    }

    private int dp1(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }


    private int dfs(int n) {

        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, dfs(n - i * i) + 1);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode279().numSquares1(12));
    }

    public int numSquares(int n) {
        return process(n);
    }

    public int process(int n) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, process(n - i * i) + 1);
        }
        return min;
    }

    public int dp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
