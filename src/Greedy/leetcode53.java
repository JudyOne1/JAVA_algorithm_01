package Greedy;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;

public class leetcode53 {
    public int maxSubArray3(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }


    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            res = Math.max(res, cur);
            if (cur <= 0) {
                cur = 0;
            }
        }

        return res;

    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = Integer.MIN_VALUE;
        int count = 0;
        // 遍历数组，计算连续子数组的和
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 更新最大和
            ans = Math.max(ans, count);
            // 如果当前累计和小于等于0，重置累计和为0，拉低总和
            if (count <= 0) {
                count = 0;
            }
        }
        return ans;
//        if (nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//        //前缀和数组
//        int[] preSum = new int[nums.length];
//        preSum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            preSum[i] = preSum[i - 1] + nums[i];
//        }
//        int max = Integer.MIN_VALUE;//-2
//        int min = 0;//-1
//        int minIndex = 0;
//        int maxIndex = 0;
//        for (int i = 0; i < preSum.length; i++) {
//            //找到最大最小相减即可，最小是最大前的最小
//            if (preSum[i] > max) {
//                maxIndex = i;
//                max = preSum[i];
//            }
//            if (preSum[i] < min && minIndex <= maxIndex) {
//                if (minIndex < maxIndex){
//                    minIndex = i;
//                    min = preSum[i];
//                }
//
//            }
//        }
//        if (min == 0 && max < 0){
//            return max - min;
//        }
//        if ((nums[maxIndex] < 0 && nums[minIndex] < 0 && max < 0 && min < 0)) {
//            return min - max;
//        }
//        return max - min;

    }

    public static void main(String[] args) {
        new leetcode53().maxSubArray(new int[]{-2, -1});
    }
}
