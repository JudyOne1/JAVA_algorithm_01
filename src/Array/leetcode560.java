package Array;

public class leetcode560 {
    public int subarraySum(int[] nums, int k) {
        //前缀和数组
        int[] presum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            // 前缀和的计算，注意数组是从1开始索引的
            presum[i+1] = nums[i] + presum[i];
        }
        // 统计和为k的子数组个数
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                //注意偏移，因为我们的nums[2]到nums[4]等于presum[5]-presum[2]
                if (presum[j+1] - presum[i] == k) {
                    // 利用前缀和数组计算nums[i,j]区间内的和，若等于k，则计数器加一
                    count++;
                }
            }
        }
        return count;

    }
}
