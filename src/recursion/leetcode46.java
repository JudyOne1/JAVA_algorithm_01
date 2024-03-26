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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        int index = 0;
        process(result, path, nums,index,used);
        return result;
    }

    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            process(result, path, nums, index + 1, used);
            path.removeLast();
            used[i] = false;
        }
    }

}
