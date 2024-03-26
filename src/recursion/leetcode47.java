package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode47 {
    /**
     * 生成给定数组的不重复全排列列表。
     * @param nums 输入的整数数组，要求元素不重复。
     * @return 返回一个列表的列表，其中每个子列表是一个不重复的全排列。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 结果列表，用于存放所有不重复的全排列
        List<List<Integer>> result = new ArrayList<>();
        // 当前全排列的路径，即逐步构建的全排列
        LinkedList<Integer> path = new LinkedList<>();
        // 用于标记某个数字是否已经被使用过，避免重复使用
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false); // 初始化所有数字为未使用状态
        Arrays.sort(nums); // 对数组进行排序，以处理重复数字的情况
        int index = 0;
        // 开始处理全排列生成
        process(result, path, nums, index, used);
        return result;
    }

    /**
     * 递归函数，用于生成不重复的全排列。
     * @param result 结果列表，存放生成的全排列。
     * @param path 当前全排列路径，逐步构建全排列。
     * @param nums 输入的整数数组。
     * @param index 当前处理的位置索引。
     * @param used 标记数组，记录数字的使用状态。
     */
    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index, boolean[] used) {
        // 当前路径长度等于数组长度时，表示一个全排列完成，将其加入结果列表
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历数组，生成全排列
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已被使用，跳过
            if (used[i]) {
                continue;
            }
            // 为了避免重复的全排列，当当前数字与前一个数字相同且前一个数字未被使用时，跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            // 标记当前数字为已使用，并将其加入当前路径
            used[i] = true;
            path.add(nums[i]);
            // 递归处理下一个位置
            process(result, path, nums, index + 1, used);
            // 回溯，将当前数字从路径中移除，并标记为未使用
            path.removeLast();
            used[i] = false;
        }
    }
}
