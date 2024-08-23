package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {

    public List<List<Integer>> threeSum3(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int plus = nums[i] + nums[left] + nums[right];
                if (plus > 0) {
                    right--;
                } else if (plus < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }

        }

        return ans;

    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 用于存储结果的列表
        ArrayList<List<Integer>> ans = new ArrayList<>();
        // 首先对数组进行排序
        Arrays.sort(nums);
        // 遍历数组，选取第一个数字
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前数字与前一个数字相同，则跳过，避免重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 设置左右指针
            int left = i + 1;
            int right = nums.length - 1;
            // 如果当前三个数字的和已经大于0，说明后续的数字组合无法再得到小于或等于0的和，终止循环
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            // 如果当前三个数字的和已经小于0，说明后续的数字组合无法再得到大于或等于0的和，跳过当前循环
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < 0) continue;
            // 使用双指针法寻找和为0的三元组
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 如果和大于0，则右指针向左移动
                if (sum > 0) {
                    right--;
                    // 如果和小于0，则左指针向右移动
                } else if (sum < 0) {
                    left++;
                    // 如果和等于0，则找到一个符合条件的三元组，将其添加到结果列表中
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 移动左指针和右指针，同时避免重复的三元组
                    left++;
                    right--;
                    // 跳过相同数字，避免重复的三元组
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return ans;
    }
}
