package Greedy;

public class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //局部最优：当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行。全局最优：找到可以跑一圈的起始位置。
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) { // 当前累加rest[i]和 curSum一旦小于0
                index = (i + 1) % gas.length ;// 起始位置更新为i+1
                curSum = 0;// curSum从0开始
            }
        }
        if (totalSum < 0) return -1;// 说明怎么走都不可能跑一圈了
        return index;
    }



}
