package search;

public class leetcode4 {
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int left = f(nums1, 0, nums2, 0, total / 2);
            int right = f(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return f(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    static int f(int[] nums1, int i, int[] nums2, int j, int k) {
        //默认第一个是小的
        if (nums1.length - i > nums2.length - j) {
            return f(nums2, j, nums1, i, k);
        }
        //当第一个数组已经用完
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }
        //当取第1个元素
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
        if (nums1[si - 1] > nums2[sj - 1]) {
            return f(nums1, i, nums2, sj, k - (sj - j));
        } else {
            return f(nums1, si, nums2, j, k - (si - i));
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int index = 0, index1 = 0, index2 = 0;

        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] <= nums2[index2]) {
                nums[index++] = nums1[index1++];
            } else {
                nums[index++] = nums2[index2++];
            }
        }
        while (index1 < len1) {
            nums[index++] = nums1[index1++];
        }
        while (index2 < len2) {
            nums[index++] = nums2[index2++];
        }
        int count = len1 + len2;
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }

    }

    public static void main(String[] args) {

    }

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
