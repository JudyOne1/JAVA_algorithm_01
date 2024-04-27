package search;

/**
 * 第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
 * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
 * 第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
 * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
 */
public class leetcode33 {
    public int search(int[] nums, int target) {
        int find = dfs(nums, target, 0, nums.length - 1);
        if (find >= nums.length || nums[find] != target) {
            return -1;
        }
        return find;
    }

    public int dfs(int[] nums, int target, int left, int right) {
        // 当左边界大于右边界时，表示已经搜索完整个数组，但未找到目标值，返回左边界
        if (left > right)
            return left;
        int mid = (left + right) / 2; // 计算当前搜索区间的中间位置

        // 如果中间位置的元素等于目标值，则返回中间位置
        if (nums[mid] == target) {
            return mid;
        } else {
            // 检查左半部分是否是有序的
            if (nums[left] <= nums[mid]) {
                // 如果目标值在左半部分的范围内，则在左半部分继续搜索，否则在右半部分搜索
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 如果左半部分不是有序的，则检查右半部分是否有序
                // 如果目标值在右半部分的范围内，则在右半部分继续搜索，否则在左半部分搜索
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 递归地继续搜索调整后的区间
            return dfs(nums, target, left, right);
        }
    }

    public static void main(String[] args) {
        new leetcode33().search(new int[]{5, 1,3}, 5);
    }
}
