package recursion;

import java.util.*;

public class leetcode90 {
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        int index = 0;
        dfs(result, path, nums, index);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {
        // 将当前路径添加到结果列表中，表示找到一个有效的组合
        result.add(new ArrayList<>(path));

        // 遍历数组中剩余的元素
        for (int i = index; i < nums.length; i++){
            // 如果当前元素与前一个元素相同，则跳过，避免重复组合
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            // 将当前元素添加到路径中，继续搜索
            path.addLast(nums[i]);
            dfs(result, path, nums, i + 1);
            // 回溯，将最后添加的元素从路径中移除
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        // 初始化结果集并加入空集
        result.add(new ArrayList<>());
        int index = 0;
        Arrays.sort(nums); // 对数组进行排序以处理重复元素
        process(result, path, nums, index); // 递归生成所有子集
        HashSet<List<Integer>> set = new HashSet<>(result); // 使用HashSet去重

        return new ArrayList<>(set); // 返回去重后的结果
    }


    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {
        if (index == nums.length){
            // 当处理到数组末尾时，将当前路径加入结果集
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++){
            // 跳过重复元素，以确保生成的子集不包含重复元素
            if ( i > index && nums[i - 1] == nums[i] ) {
                continue;
            }
            path.add(nums[i]); // 将当前元素加入路径
            result.add(new ArrayList<>(path)); // 将当前路径加入结果集
            process(result, path, nums, i+1); // 递归生成下一个元素的子集
            path.removeLast(); // 回溯，移除最后一个元素
        }
    }

}
