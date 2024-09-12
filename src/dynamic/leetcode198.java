package dynamic;

public class leetcode198 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
     * 一夜之内能够偷窃到的最高金额。
     */

    public int rob2(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[1];
        } else if (len == 2) {
            return Math.max(nums[1], nums[2]);
        }

        int[] dp = new int[len + 1];
        dp[len - 1] = nums[len - 1];
        dp[len - 2] = Math.max(nums[len - 1], nums[len - 2]);

        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
        //dp[i] = nums[i] + dp[i+2] | dp[i+1]
//        return dfs2(nums, 0);
    }

    private int dfs2(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[nums.length - 1];
        } else if (index == nums.length - 2) {
            return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        }

        return Math.max(nums[index] + dfs2(nums, index + 2), dfs2(nums, index + 1));
    }


    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int money = 0;
        int index = 0;
        return dfs(nums, money, index);


    }

    private int dfs(int[] nums, int money, int index) {
        if (index >= nums.length) {
            return money;
        }
        if (index == nums.length - 1) {
            return money + nums[index];
        }
        return Math.max(dfs(nums, money, index + 1), dfs(nums, money + nums[index], index + 2));
    }

    private int dp1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //从后往前
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return process(nums, 0);
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

    public static void main(String[] args) {
        System.out.println(new leetcode198().rob(new int[]{1, 2, 3, 1}));
    }
}
