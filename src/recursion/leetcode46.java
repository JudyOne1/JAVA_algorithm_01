package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 */
public class leetcode46 {
    /**
     * 生成给定数组的所有排列组合。
     *
     * @param nums 输入的整数数组
     * @return 所有可能的排列组合列表，每个排列组合都是一个整数列表
     */
    public List<List<Integer>> permute(int[] nums) {
        // 结果集合，存放所有排列组合
        List<List<Integer>> result = new ArrayList<>();
        // 当前排列组合的路径，即正在构建的排列
        LinkedList<Integer> path = new LinkedList<>();
        // 标记数组，用于记录数字是否已经被使用
        boolean[] used = new boolean[nums.length];
        // 初始化标记数组，全部置为未使用状态
        Arrays.fill(used, false);
        // 当前处理的数字索引
        int index = 0;
        // 开始处理排列组合
        process(result, path, nums, index, used);
        return result;
    }

    /**
     * 递归生成数组的排列组合。
     *
     * @param result 存放所有排列组合的结果集合
     * @param path 当前排列组合的路径
     * @param nums 输入的整数数组
     * @param index 当前处理的数字索引
     * @param used 标记数组，记录数字是否已经被使用
     */
    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index, boolean[] used) {
        // 当前路径中的数字数量等于输入数组长度时，将此路径加入结果集合
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历数组中的每个数字
        for (int i = 0; i < nums.length; i++) {
            // 如果数字已经被使用，则跳过
            if (used[i]) {
                continue;
            }
            // 标记当前数字为已使用
            used[i] = true;
            // 将当前数字加入路径
            path.add(nums[i]);
            // 递归生成下一个数字的排列组合
            process(result, path, nums, index + 1, used);
            // 回溯：移除最后一个数字，标记为未使用
            path.removeLast();
            used[i] = false;
        }
    }

}
