package dynamic;

import java.util.Arrays;
import java.util.Collections;

public class leetcode322 {
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE / 2); // 除 2 是防止下面 + 1 溢出
        f[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int c = 0; c <= amount; ++c) {
                if (c < coins[i]) {
                    f[i + 1][c] = f[i][c];
                } else {
                    f[i + 1][c] = Math.min(f[i][c], f[i + 1][c - coins[i]] + 1);
                }
            }
        }
        int ans = f[n][amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    public int coinChange1(int[] coins, int amount) {
        int ans = dfs(coins, amount, 0);
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;

    }

    private int dp1(int[] coins, int amount) {

        int N = coins.length; // 硬币面额数组的长度
        int[][] dp = new int[N + 1][amount + 1]; // 动态规划数组，dp[i][j] 表示使用前 i 种硬币凑出金额 j 需要的最少次数
        Arrays.fill(dp[N], Integer.MAX_VALUE / 2); // 初始化最后一个硬币种类凑出任意金额的值为一个极大值，表示不使用该硬币
        dp[N][0] = 0; //凑出金额为 0 时，需要的次数为 0

        // 从倒数第一个硬币开始向前遍历
        for (int i = N - 1; i >= 0; i--) {
            // 遍历所有可能的目标金额
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i] >= 0) { // 当前硬币面额小于等于目标金额时，可以使用该硬币
                    // 选择使用或不使用当前硬币中的较小次数
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - coins[i]] + 1);
                } else { // 不能使用当前硬币
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][amount]; // 返回凑出目标金额需要的最少次数

    }


    private int dfs(int[] coins, int amount, int index) {
        // 当遍历完所有硬币时，如果当前金额恰好为0，表示已找到一种组合达到目标金额，返回0；否则，返回一个极大值表示无法达成目标。
        if (index == coins.length) {
            return amount == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        // 如果当前硬币的面额大于目标金额，跳过此硬币，继续考虑下一个硬币。
        if (amount - coins[index] < 0) {
            return dfs(coins, amount, index + 1);
        }
        // 递归考虑两种情况：使用当前硬币和不使用当前硬币，返回需要的最少硬币数。
        return Math.min(dfs(coins, amount, index + 1), dfs(coins, amount - coins[index], index) + 1);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
//        int ans = process(coins, amount, 0);
        int ans = dp(coins, amount);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public int process(int[] coins, int amount, int index) {

        if (index == coins.length) {//没钱了，且rest=0，那么只需要0张组成rest
            return amount == 0 ? 0 : Integer.MAX_VALUE;
        } else {
            // 从后往前遍历硬币面额，尝试使用当前面额的硬币
            int ans = Integer.MAX_VALUE;
            for (int zhang = 0; zhang <= amount / coins[index]; zhang++) {
                // 递归计算剩余金额需要的最少硬币数量
                int next = process(coins, amount - zhang * coins[index], index + 1);
                // 如果递归有解，则更新最少硬币数量
                if (next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, next + zhang);
                }
            }
            return ans;
        }
    }

    public static int dp(int[] coins, int amount) {
        // 如果目标金额为0，不需要任何硬币
        if (amount == 0) {
            return 0;
        }
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];

        // 初始化边界条件
        dp[N][0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[N][j] = Integer.MAX_VALUE; // 设为最大值表示不可达
        }

        // 从最后一个硬币开始向前计算
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= amount; rest++) {
                int ans = Integer.MAX_VALUE; // 初始化为最大值，表示当前金额在不使用当前硬币时的最小需要硬币数

                // 尝试使用当前硬币
                for (int zhang = 0; zhang * coins[index] <= rest; zhang++) {
                    int next = dp[index + 1][rest - zhang * coins[index]];
                    // 如果使用当前硬币后能够达到剩余金额，则更新最小硬币数
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(ans, zhang + next);
                    }
                }

                dp[index][rest] = ans; // 记录使用当前硬币得到的最小硬币数
            }
        }

        return dp[0][amount]; // 返回目标金额所需的最小硬币数
    }


    public static void main(String[] args) {
        System.out.println(new leetcode322().coinChange(new int[]{1, 2, 5}, 11));
    }
}
