package dynamic;

public class leetcode152 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(nums, i));
        }
        return ans;
    }

    private int dfs(int[] nums, int index) {
        int max = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i) * nums[i]);
        }
        return max;
    }

    private int dp(int[] nums) {
        int max = Integer.MIN_VALUE;//结果最大值
        int imax = 1;// 阶段最大值
        int imin = 1;// 阶段最小值

        for (int cur : nums) {
            //当遇到负数的时候进行交换，因为阶段最小X负数就变阶段最大了，反之同理
            if (cur < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //在这里用乘积和元素本身比较的意思是：
            //对于最小值来说，最小值是本身则说明这个元素值比前面连续子数组的最小值还小。相当于重置了阶段最小值的起始位置
            imax = Math.max(imax * cur, cur);
            imin = Math.min(imin * cur, cur);
            //对比阶段最大值和结果最大值
            max = Math.max(imax, max);
        }
        return max;
    }
}
