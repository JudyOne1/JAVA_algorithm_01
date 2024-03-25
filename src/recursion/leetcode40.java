package recursion;

import java.util.*;

//https://leetcode.cn/problems/combination-sum-ii/
public class leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        process(candidates, target, path, result, 0, used);

        return result;
    }

    private static void process(int[] candidates, int target, LinkedList<Integer> path, List<List<Integer>> result, int startIndex, boolean[] used) {
        int sum = 0;
        for (Integer i : path) {
            sum += i;
        }
        // 当结果等于n时，将路径加入结果列表
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            // 剪枝
            used[i] = true;
            // 将当前数字加入路径
            path.addLast(candidates[i]);
            // 递归  // 每个节点仅能选择一次，所以从下一位开始             ↓区别在这里 i变成了i+1
            process(candidates, target, path, result, i + 1, used);
            // 回溯 移除当前数字
            used[i] = false;
            path.removeLast();
        }
    }
}
