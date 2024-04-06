package dynamic;

public class leetcode718 {
    public int findLength(int[] nums1, int[] nums2) {
        return nums1.length <= nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
    }

    public int findMax(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length, n = nums2.length;
        /**
         nums1,nums2中较短的数组不动，这里默认nums1，较长的数组滑动
         初始位置：nums2右边界挨着nums1左边界，nums2从左往右滑动
         */
        // 第一阶段：nums2从左往右滑动，两数组重合部分长度不断 增加，重合部分长度len从1开始增加
        // 重合部分：nums1起点下标0，nums2起点下标n-len，
        for (int len = 1; len <= m; len++) {
            max = Math.max(max, maxLen(nums1, 0, nums2, n - len, len));
        }
        // 第二阶段：nums2从左往右滑动，两数组重合部分长度 不变，重合部分长度始终为nums1长度m
        //  重合部分：nums1起点下标0，nums2起点下标n-m，然后递减
        for (int j = n - m; j >= 0; j--) {
            max = Math.max(max, maxLen(nums1, 0, nums2, j, m));
        }
        // 第三阶段：nums2从左往右滑动，两数组重合部分长度 递减，重合部分长度始终为nums1长度m-i
        //  重合部分：nums1起点下标i，递增，nums2起点下标0
        for (int i = 1; i < m; i++) {
            max = Math.max(max, maxLen(nums1, i, nums2, 0, m - i));
        }
        return max;
    }

    /**
     * nums1中下标i开始，nums2中下标j开始，长度为len子数组中，最长公共子数组(注意要连续)长度
     */
    public int maxLen(int[] nums1, int i, int[] nums2, int j, int len) {
        int count = 0, res = 0;
        for (int k = 0; k < len; k++) {
            if (nums1[i + k] == nums2[j + k]) {
                count++;
            } else if (count > 0) {
                //进入到这个if判断体里面，说明当前 nums1[i+k]!=nums2[j+k],即之前的公共子数组不再连续，
                // 所以要记录最大值，同时将count置零
                res = Math.max(count, res);
                count = 0;
            }
        }
        /**
         1，count>0,说明有公共子数组是以nums1[i+len-1],nums2[j+len-1]结尾的，
         上面最后一步for循环没有进入到else if判断题里面，所以最终结果要取当前count和res的最大值
         2，count=0，说明res已经更新过了，res即为最终结果
         */
        return count > 0 ? Math.max(count, res) : res;
    }
}
