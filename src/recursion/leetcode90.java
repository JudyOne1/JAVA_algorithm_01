package recursion;

import java.util.*;

public class leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        //加入空集
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        int index = 0;
        process(result,path,nums,index);
        HashSet<List<Integer>> set = new HashSet<>(result);

        return new ArrayList<>(set);
    }

    private void process(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int index) {
        if (index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++){
            if ( i > index && nums[i - 1] == nums[i] ) {
                continue;
            }
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            process(result,path,nums,i+1);
            path.removeLast();
        }
    }
}
