package search;

public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        // 如果数组为空，直接返回 [-1, -1]
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        // 使用深度优先搜索找到目标值的第一个出现位置
        int find = dfs(nums, target, 0, nums.length - 1);
        // 如果找不到目标值或找到的位置不是目标值的起始位置，返回 [-1, -1]
        if (find>=nums.length ||nums[find] != target){
            return new int[]{-1,-1};
        }
        // 确定目标值的最左索引
        int start = find;
        while(start > 0 && nums[start-1] == target)
            start--;
        // 确定目标值的最右索引
        int end = find;
        while(end < nums.length-1 && nums[end+1] == target)
            end++;
        // 返回目标值的最左和最右索引
        return new int[]{start,end};
    }
    public int dfs(int[] nums, int target, int left, int right){
        // 当左边界大于右边界时，表示目标值不存在，返回左边界
        if(left > right)
            return left;
        // 计算中点
        int mid = (left + right) / 2;
        // 如果找到目标值，则返回当前索引
        if(nums[mid] == target)
            return mid;
            // 如果目标值在左侧，则在左半部分继续查找
        else if(nums[mid] > target)
            return dfs(nums, target, left, mid - 1);
            // 如果目标值在右侧，则在右半部分继续查找
        else
            return dfs(nums, target, mid + 1, right);
    }

    public int[] searchRangel(int[] nums, int target) {
        int start = lowerBound(nums, target); // 选择其中一种写法即可
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1}; // nums 中没有 target
        }
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

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
        return left;
    }

    // 左闭右开区间写法
    private int lowerBound2(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1; // 范围缩小到 [mid+1, right)
            } else {
                right = mid; // 范围缩小到 [left, mid)
            }
        }
        return left; // 返回 left 还是 right 都行，因为循环结束后 left == right
    }

    // 开区间写法
    private int lowerBound3(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right;
    }
}
