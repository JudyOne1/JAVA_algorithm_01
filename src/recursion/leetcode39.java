package recursion;

import java.util.*;
/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class leetcode39 {
    //使用set集合去重
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        process(candidates, target, path, result, 0);

        return new ArrayList<>(result);
    }

    private static void process(int[] candidates, int target, LinkedList<Integer> path, HashSet<List<Integer>> result, int startIndex) {
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
            // 将当前数字加入路径
            path.addLast(candidates[i]);
            // 递归
            process(candidates, target, path, result, i);
            // 移除当前数字
            path.removeLast();
        }
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);
    }
}
