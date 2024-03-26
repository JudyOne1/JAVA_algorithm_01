package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class leetcode491 {
    /**
     * 查找给定整数数组中的所有子序列，这些子序列至少包含两个元素，且不必重新排序，同时满足子序列是递增的或相等的。
     *
     * @param nums 整数数组，提供给查找子序列的源数据。
     * @return 返回一个列表，其中包含输入数组中所有满足条件的不重复子序列。
     */
        public List<List<Integer>> findSubsequences(int[] nums) {
            // 结果集合，用于存放所有满足条件的子序列
            List<List<Integer>> result = new ArrayList<>();
            // 当前探索路径，即当前构建的子序列
            LinkedList<Integer> path = new LinkedList<>();

            // 初始化处理过程
            int index = 0;
            process(result, path, nums, index);

            // 使用集合去重，因为过程中可能会产生重复的子序列
            HashSet<List<Integer>> set = new HashSet<>(result);

            // 返回去重后的结果集合
            return new ArrayList<>(set);
        }

        /**
         * 递归处理函数，用于生成所有可能的满足条件的子序列。
         *
         * @param result 存放结果的集合
         * @param path 当前探索的路径，即正在构建的子序列
         * @param nums 整数数组，源数据
         * @param index 当前处理元素的索引
         */
        private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {
            // 当路径长度大于等于2时，将当前路径加入结果集合，因为最短的子序列也需要两个元素
            if (path.size() >= 2) {
                result.add(new ArrayList<>(path));
            }
            // 遍历数组，尝试将当前元素加入路径中
            for (int i = index; i < nums.length; i++) {
                // 当路径为空，或者当前元素大于等于路径的最后一个元素时，可以将当前元素加入路径
                if (path.isEmpty() || nums[i] >= path.getLast()) {
                    path.add(nums[i]);
                    // 递归继续探索加入新元素后的路径
                    process(result, path, nums, i + 1);
                    // 回溯，移除最后一个加入的元素
                    path.removeLast();
                }
            }
        }

    public static void main(String[] args) {
        leetcode491 test = new leetcode491();
        int[] nums = {4,4,3,2,1};
        test.findSubsequences(nums);

    }
}
