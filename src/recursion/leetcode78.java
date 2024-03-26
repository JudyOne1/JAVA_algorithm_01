package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        //加入空集
        result.add(new ArrayList<>());
        int index = 0;
        process(result,path,nums,index);
        HashSet<List<Integer>> set = new HashSet<>(result);

        return new ArrayList<List<Integer>>(set);
    }

    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {
        if (index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++){
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            process(result,path,nums,i+1);
            path.removeLast();
        }
    }
}
