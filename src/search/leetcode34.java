package search;

public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        int find = dfs(nums, target, 0, nums.length - 1);
        if (find>=nums.length ||nums[find] != target){
            return new int[]{-1,-1};
        }
        int start = find;
        while(start > 0 && nums[start-1] == target)
            start--;
        int end = find;
        while(end < nums.length && nums[end+1] == target)
            end++;
        return new int[]{start,end};
    }
    public int dfs(int[] nums, int target, int left, int right){
        if(left > right)
            return left;
        int mid = (left + right) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target)
            return dfs(nums, target, left, mid - 1);
        else
            return dfs(nums, target, mid + 1, right);
    }
}
