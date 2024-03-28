package Greedy;

import java.util.Arrays;

public class leetcode1005 {
    /**
     * 在给定数组中，经过K次取反操作后，返回能得到的最大和
     * @param nums 给定的整数数组
     * @param k 可以进行的取反操作次数
     * @return 经过K次取反操作后能得到的最大和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        //先对数组进行排序，负数在前面，把负数绝对值最大的K个数取反
        //如果全部都变成了正数，但 K 还大于零，那么就取绝对值最小的正数取反
        // 首先对数组进行排序，将负数排在前面
        Arrays.sort(nums);
        // 遍历数组，将负数绝对值最大的K个数取反
        for (int i = 0; i < nums.length && k > 0; i++) {
            // 当遇到非负数时停止取反操作
            if (nums[i] >= 0) {
                break;
            }
            nums[i] = -nums[i];
            // 每取反一个数，K值减一
            k--;
        }
        // 如果还有剩余的取反次数，且次数为奇数，则对数组中绝对值最小的正数取反
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        // 计算数组所有元素的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 返回最大和
        return sum;
    }

}
