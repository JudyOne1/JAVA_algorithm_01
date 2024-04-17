package Array;

public class leetcode238 {
    /**
     * 计算数组中每个元素除自身外的乘积
     * @param nums 输入的整数数组
     * @return 一个新的整数数组，其中每个元素是原数组中除自身外所有元素的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        // 计算每个元素前面所有元素的乘积
        int[] pre = new int[nums.length];
        // 计算每个元素后面所有元素的乘积
        int[] suf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pre[i] = nums[i] * (i == 0 ? 1 : pre[i - 1]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            suf[i] = nums[i] * (i == nums.length - 1 ? 1 : suf[i + 1]);
        }
        // 根据前面和后面乘积数组，计算最终结果
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = i == 0 ? suf[i + 1] : i == nums.length - 1 ? pre[i - 1] : pre[i - 1] * suf[i + 1];
        }
        return res;
    }
}
// 1  2  6  24
// 24 24 12 4