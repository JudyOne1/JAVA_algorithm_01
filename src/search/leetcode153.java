package search;

public class leetcode153 {
    public int findMin(int[] nums) {
        int min = nums[0];
        return dfs(nums, min, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int min, int left, int right) {
        if (left > right)
            return left;
        int mid = (left + right) / 2;
        if (nums[mid] < min) {
            min = nums[mid];
            return min;
        } else if (nums[mid] > min) {
            dfs(nums, min, mid + 1, right);
            return dfs(nums, min, left, mid - 1);
        }
        return dfs(nums, min, left, mid - 1);
    }
    // 闭区间写法
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1; // 范围缩小到 [mid+1, right]
            } else {
                right = mid - 1; // 范围缩小到 [left, mid-1]
            }
        }
        return nums[left];
    }
}
