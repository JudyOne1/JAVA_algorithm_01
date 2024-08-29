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

    public List<List<Integer>> permute3(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums == null){
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] arrived = new boolean[nums.length];
        dfs2(nums,arrived,path,ans);
        return ans;
    }

    private void dfs2(int[] nums, boolean[] arrived, ArrayList<Integer> path, ArrayList<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arrived[i]){
                continue;
            }
            arrived[i] = true;
            path.add(nums[i]);
            dfs2(nums,arrived,path,ans);
            arrived[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        List<Integer> path = new ArrayList<>();
        boolean[] arrived = new boolean[nums.length];
        dfs1(nums, result, path, arrived);
        return result;
    }

    private void dfs1(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] arrived) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arrived[i]) {
                continue;
            }
            path.add(nums[i]);
            arrived[i] = true;
            dfs1(nums, result, path, arrived);
            path.remove(path.size() - 1);
            arrived[i] = false;
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, visited, ans, path);
        return ans;
    }

    public void dfs(int[] nums, boolean[] visited, List<List<Integer>> result, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                //没来过
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, result, path);
                visited[i] = false;
                path.removeLast();
            } else {
                continue;
            }

        }
    }

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
