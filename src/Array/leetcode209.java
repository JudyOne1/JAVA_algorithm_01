package Array;

import java.util.LinkedList;

public class leetcode209 {
    //滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE; // 初始化变量，min用于记录最小窗口长度
        while (right < nums.length) { // 右指针遍历数组
            sum += nums[right++]; // 将右指针指向的元素加到当前和上
            while (sum >= target) { // 当 当前和大于等于目标值时，收缩窗口
                min = Math.min(min, right - left); // 更新最小窗口长度
                sum -= nums[left++]; // 将左指针指向的元素从当前和中减去
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min; // 如果未找到满足条件的窗口，返回0，否则返回最小窗口长度
    }



    //way01 超出时间限制
    public static int minSubArrayLen1(int target, int[] nums) {
        int[] helper = new int[nums.length];
        helper[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //生成前缀数组
            helper[i] += helper[i-1]+nums[i];
        }
        for (int w = 1; w <= nums.length; w++) {
            LinkedList<Integer> qmax = new LinkedList<Integer>();
            for (int R = 0; R < nums.length; R++) {
                // 加入尾部
                qmax.addLast(R);
                //R - w 是 过期的下标
                if (qmax.peekFirst() == R - w) {
                    //弹出过期的首部
                    qmax.pollFirst();
                }
                int res= nums[qmax.peekLast()];
                if (w >= 2 && qmax.peekFirst() == 0){
                    res = helper[qmax.peekLast()];
                }else if (w >= 2 && qmax.peekFirst() >0){
                    res= helper[qmax.peekLast()]-helper[qmax.peekFirst()-1];
                }else if (w == nums.length){
                    res = helper[qmax.peekLast()];
                }

                //形成正常的窗口
                if (target <= res) {
                    //填写答案
                    return w;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        System.out.println(minSubArrayLen(5,nums));
    }
}
