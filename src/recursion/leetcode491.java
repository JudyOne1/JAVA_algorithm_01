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
    public List<List<Integer>> findSubsequences(int[] nums) {
        //不可以重新排序，是递增序列，相等也算。最少两个
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        int index = 0;
        process(result,path,nums,index);
        HashSet<List<Integer>> set = new HashSet<>(result);

        return new ArrayList<>(set);
    }

    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {
        if(path.size()>=2){
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++){
            //path为空，或者递增，就可以添加
            if(path.isEmpty() || nums[i] >= path.getLast()){
                path.add(nums[i]);//为什么没有 46 44
                process(result,path,nums,i+1);
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
