package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 */

public class leetcode15 {
//[-1,0,1,2,-1,-4,-2,-3,3,0,4]
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    // 找出a + b + c = 0
    // a = nums[i], b = nums[left], c = nums[right]
    for (int i = 0; i < nums.length; i++) {
        // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
        if (nums[i] > 0) {
            return result;
        }

        if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
            continue;
        }

        int left = i + 1;
        int right = nums.length - 1;
        while (right > left) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;

                right--;
                left++;
            }
        }
    }
    return result;
}


    //报错，部分正确，有问题：数组中重复值的处理
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null){
            return null;
        }
        HashSet<List<Integer>> set = new HashSet<>();
        //先把数组进行从小到大排序
        Arrays.sort(nums);
        //然后设定指针 i，left，right，right指针指向数组的末尾，left指针指向 1+1，i指针指向数组的开头
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (nums[i]+nums[left]+nums[right] == 0){
                set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
                if (left+1 == right && nums[i]+nums[left]+nums[right] == 0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                }
            }
            //小于零则说明 left 需要往右移
            while (left < right && nums[i]+nums[left]+nums[right] < 0){
                if (left + 1 == right){
                    if (nums[i]+nums[left]+nums[right] == 0) {
                        set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    break;
                }else {
                    left++;
                }

                if (nums[i]+nums[left]+nums[right] == 0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    if (left+2<right){
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                    }
                }
            }
            //大于零则说明 right 需要往左移
            //[-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]
            //-2 -1 3
            //-2 0 2
            while (left < right && nums[i]+nums[left]+nums[right] > 0){
                if (right - 1 == left){
                    if (nums[i]+nums[left]+nums[right] == 0) {
                        set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    break;
                }else {
                    right--;
                }
                if (nums[i]+nums[left]+nums[right] == 0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    if (left+2<right){
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        //重复需要跳过
                    }
                }
            }

        }
        return new ArrayList<>(set);
    }

}
