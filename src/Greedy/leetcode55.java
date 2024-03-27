package Greedy;

import java.util.Arrays;

public class leetcode55 {

    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;


//复杂度较高
//        // 当数组长度为1时，无需跳跃即可到达末尾
//        if (nums.length == 1){
//            return true;
//        }
//        // 如果起始位置跳跃距离为0，则无法继续跳跃
//        if (nums[0] == 0){
//            return false;
//        }
//        // 创建一个临时数组并对其进行排序，用于找到最小的跳跃距离
//        int[] temp = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(temp);
//        // 如果最小的跳跃距离大于0，表示无论如何都能跳跃到数组的末尾
//        if (temp[0] > 0){
//            return true;
//        }
//
//        // 遍历数组，检查每个位置是否能够跳跃到数组的末尾
//        for (int i = 0; i < nums.length; i++) {
//            // 当前位置跳跃距离为0
//            if (nums[i] == 0){
//                // 倒序遍历前面的位置，检查是否存在足够的跳跃距离到达当前位置
//                for (int j = i - 1; j >= 0; j--) {
//                    // 如果存在足够的跳跃距离，或当前位置为数组末尾且前面的位置可以跳到末尾，则跳出内循环
//                    if (nums[j] > i - j || (nums[j] >= i - j && i == nums.length - 1)){
//                        break;
//                    }
//                    // 如果遍历到起始位置仍无法到达当前位置，则返回false
//                    if (j == 0){
//                        return false;
//                    }
//                }
//            }
//        }
//        // 如果所有位置都能到达，则返回true
//        return true;
    }


    public static void main(String[] args) {
        new leetcode55().canJump(new int[]{3,2,1,0,4});
    }

}
