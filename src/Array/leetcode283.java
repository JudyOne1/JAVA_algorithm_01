package Array;

import java.util.Arrays;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        // 遍历数组，将非零元素移到数组前部
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        // 将`index`到数组末尾的位置填充为零
        Arrays.fill(nums, index, nums.length, 0);
    
    }
}
