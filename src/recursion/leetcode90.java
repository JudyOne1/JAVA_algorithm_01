package recursion;

import java.util.*;

public class leetcode90 {
    /**
     * 生成包含重复元素的子集列表。
     * @param nums 输入的整数数组，可能包含重复元素。
     * @return 返回一个列表的列表，其中每个子列表都是输入数组的一个不重复的子集。
     */
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

    /**
     * 递归生成数组的所有子集（不包含重复元素）。
     * @param result 存储所有生成的子集的列表
     * @param path 当前生成的子集路径
     * @param nums 输入的整数数组
     * @param index 当前处理的元素索引
     */
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
