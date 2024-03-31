package dynamic;

public class leetcode509 {

    /**
     * 计算第n个斐波那契数。
     *
     * @param n 斐波那契数的索引，从0开始计数。
     * @return 返回第n个斐波那契数。
     */
    public int fib(int n) {
        return process(n);
    }

    /**
     * 递归方式计算第n个斐波那契数。
     *
     * @param n 斐波那契数的索引，从0开始计数。
     * @return 返回第n个斐波那契数。
     */
    public int process(int n){
        // base case
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        // 递归计算
        return process(n-1) + process(n-2);
    }

    /**
     * 动态规划方法计算第n个斐波那契数。
     *
     * @param n 斐波那契数的索引，从0开始计数。
     * @return 返回第n个斐波那契数。
     */
    public int dp(int n){
        // 基本情况的处理
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        // 动态规划数组初始化
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        // 动态规划递推
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 返回结果
        return dp[n];
    }
}
