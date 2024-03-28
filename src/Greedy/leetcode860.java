package Greedy;

public class leetcode860 {
    /**
     * 变换零钱问题：判断给定的钞票数组是否能够通过组合支付顾客的订单。
     * 假设顾客每次支付都是5元、10元或者20元，且你的零钱充足。
     * 如果可以凑出顾客需要支付的金额，则返回true；否则返回false。
     *
     * @param bills 给定的钞票数组，包含5元、10元和20元的钞票。
     * @return 返回是否能够凑出顾客需要支付的金额。
     */
    public boolean lemonadeChange(int[] bills) {
        // 如果没有顾客支付，直接返回true
        if (bills.length == 0){
            return true;
        }
        // 如果第一个顾客支付的不是5元，直接返回false
        if (bills[0] != 5){
            return false;
        }

        // 统计前缀中5元钞票的数量，用于快速响应10元的支付
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }else if (bills[i] == 10 || bills[i] == 20) {
                break;
            }
        }

        // 处理剩余的钞票，以确定是否能够应对各种支付
        for (int i = five; i < bills.length; i++) {
            if (bills[i] == 5){
                five++;
            }else if (bills[i] == 10){
                // 当收到10元时，需要有一个5元来配合
                if (five > 0){
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else {
                // 当收到20元时，优先使用5元和10元组合支付
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if (five > 2){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
