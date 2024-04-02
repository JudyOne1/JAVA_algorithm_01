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

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] += dp[i + 1][j-];
            }
        }
        return dp[coins.length][amount];
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
