package dynamic;

import java.util.Arrays;

public class leetcode416 {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
    }

    public int process(int[] nums,int index) {
        if(index == nums.length-1){
            return nums[index];
        }
        int number1 = process(nums,index+1)+nums[index+1];
        int number2 = Math.max(process(nums,index+1)+nums[index+1],process(nums,index+2));
        return Math.max(number1, number2);

    }
}
