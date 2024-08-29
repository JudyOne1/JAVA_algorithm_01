package search;

public class leetcode153 {

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMin1(int[] nums) {
        /**
         * 设 x=nums[mid] 是现在二分取到的数。
         *
         * 我们需要判断 x 和数组最小值的位置关系，谁在左边，谁在右边？
         *
         * 把 x 与最后一个数 nums[n−1] 比大小：
         *
         * 如果 x>nums[n−1]，那么可以推出以下结论：
         * nums 一定被分成左右两个递增段；
         * 第一段的所有元素均大于第二段的所有元素；
         * x 在第一段。
         * 最小值在第二段。
         * 所以 x 一定在最小值的左边。
         *
         * 如果 x≤nums[n−1]，那么 x 一定在第二段。（或者 nums 就是递增数组，此时只有一段。）
         * x 要么是最小值，要么在最小值右边。
         * 所以，只需要比较 x 和 nums[n−1] 的大小关系，就间接地知道了 x 和数组最小值的位置关系，从而不断地缩小数组最小值所在位置的范围，二分找到数组最小值。
         */
        int l = 0;
        int r = nums.length - 2;
        while (l <= r) {
            int mid = (r + l) / 2;
            // 1 2 3 4 5 6
            // 3 4 5 6 7 0 1 2
            if (nums[mid] < nums[nums.length - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

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
