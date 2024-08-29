package search;

public class leetcode35 {
    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        return dfs(nums, target, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int target, int left, int right) {
        if (left > right)
            return left;
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return dfs(nums, target, left, mid - 1);
        else
            return dfs(nums, target, mid + 1, right);
    }
}
