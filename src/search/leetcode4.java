package search;

public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        // 保证nums1是长度较小的数组
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        // 处理空数组的情况
        if (nums1.length == 0) {
            if (nums2.length % 2 != 0) return nums2[length / 2];
            else return (nums2[length / 2 - 1] + nums2[length / 2]) / 2.0;
        }
        // 初始化二分查找的边界
        int L_edge = 0, R_edge = nums1.length;
        int cur1 = 0, cur2 = 0;
        double result = 0;
        // 二分查找
        while (L_edge <= R_edge) {
            cur1 = L_edge + (R_edge - L_edge) / 2;
            cur2 = (length + 1) / 2 - cur1;
            // 计算当前分割点对应的左右值
            double L1 = cur1 == 0 ? Integer.MIN_VALUE : nums1[cur1 - 1];
            double R1 = cur1 == nums1.length ? Integer.MAX_VALUE : nums1[cur1];
            double L2 = cur2 == 0 ? Integer.MIN_VALUE : nums2[cur2 - 1];
            double R2 = cur2 == nums2.length ? Integer.MAX_VALUE : nums2[cur2];
            // 根据左右值调整二分查找边界
            if (L1 > R2) R_edge = cur1 - 1;
            else if (L2 > R1) L_edge = cur1 + 1;
            else {
                // 计算中位数
                if (length % 2 != 0) result = Math.max(L1, L2);
                else result = (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                break;
            }
        }
        return result;
    }
}
