package Array;

public class leetcode162 {
    public int findPeakElement(int[] nums) {
        int left = -1, right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid; // 蓝色
            } else {
                left = mid;  // 红色
            }
        }
        return right;
    }
}
