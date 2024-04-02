package dynamic;

public class leetcode518 {
    public int change(int amount, int[] coins) {
        return process(amount,coins,0);
    }
    // coins[index....] 所有的面值，每一个面值都可以任意选择张数，组成正好amount这么多钱，方法数多少？
    public static int process( int amount,int[] coins, int index) {
        if (index == coins.length) { // 没钱了
            return amount == 0 ? 1 : 0;
        }
        int ways = 0;
        //index位置的货币选择张数从 0 张开始试，但是 (张数 * 当前的货币值) 结果不能比amount大
        //因此此处有限制，所以不会出现amount < 0 的情况
        for (int zhang = 0; zhang * coins[index] <= amount; zhang++) {//上游控制
            //index位置选择了张数后，轮到下一个位置做选择，有几种方法
            ways += process(amount - (zhang * coins[index]),coins, index + 1);
        }
        return ways;
    }
    public int dp(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= amount; rest++) {
                int ways = 0;

                for (int zhang = 0; zhang * coins[index] <= rest; zhang++) {//需要枚举(for循环)才能搞出一个格子，需要继续优化
                    ways += dp[index + 1][rest - (zhang * coins[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][amount];
    }
    public static int dp2(int amount,int[] coins) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= amount; rest++) {
                dp[index][rest] = dp[index + 1][rest];// a 楼下位置的值
                if (rest - coins[index] >= 0) {
                    dp[index][rest] += dp[index][rest - coins[index]];// ※
                }
            }
        }
        return dp[0][amount];
    }
//    public int process(int amount, int[] coins,int index){
//        if(amount == 0){
//            return 1;
//        }
//        if (amount < 0){
//            return 0;
//        }
//        int res = 0;
//        for (int i = index; i < coins.length; i++) {
//            res+=process(amount-coins[i],coins,index+i);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        leetcode518 leetcode518 = new leetcode518();
        System.out.println(leetcode518.change(500,new int[]{1,2,5}));
    }
}
