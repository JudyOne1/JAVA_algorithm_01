package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class leetcode78 {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        // 初始化结果集，加入空集作为起始
        result.add(new ArrayList<>());
        int index = 0;
        dfs(nums,result,path,index);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, LinkedList<Integer> path, int index) {
        if (index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(nums,result,path,index+1);//拿
        path.removeLast();
        dfs(nums,result,path,index+1);//不拿

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        // 初始化结果集，加入空集作为起始
        result.add(new ArrayList<>());
        int index = 0;
        process(result, path, nums, index);

        // 使用HashSet去重，确保结果中没有重复的子集
        HashSet<List<Integer>> set = new HashSet<>(result);

        return new ArrayList<List<Integer>>(set);
    }


    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {

        //将当前路径加入结果集
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            // 尝试将当前元素加入路径，递归生成子集
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            process(result, path, nums, i + 1);

            // 回溯，移除最后一个元素以生成其他可能的子集
            path.removeLast();
        }
    }
}
