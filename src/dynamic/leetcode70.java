package dynamic;

public class leetcode70 {
    public int climbStairs1(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return dfs(n - 1) + dfs(n - 2);

    }

    private int dp1(int n){
        int[] map = new int[n + 1];
        map[0] = 0;
        map[1] = 1;
        map[2] = 2;
        for (int i = 3; i < map.length; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[n];
    }

    public int climbStairs(int n) {
        return process(n);
    }

    public int process(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            //只能走1
            return 1;
        } else if (n == 2) {
            //可以走1+1或者2
            return 2;
        } else {
            return process(n - 1) + process(n - 2);
        }
    }

    public int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            //只能走1
            return 1;
        }
        if (n == 2) {
            //可以走1+1或者2
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
