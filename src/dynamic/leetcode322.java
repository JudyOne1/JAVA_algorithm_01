package dynamic;

import java.util.Arrays;
import java.util.Collections;

public class leetcode322 {
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
