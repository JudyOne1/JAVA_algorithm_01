package hashTable;

import java.util.HashMap;

public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //key 存数字，value 存下标；
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                //如果存在所需要的数字，那么就找到了，返回下标即可
                return new int[]{hashMap.get(target-nums[i]), i};
            }else {
                //如果不存在，那么就将当前数字存入hashMap中，key为当前数字，value为下标
                hashMap.put(nums[i], i);
            }
        }
        return null;


//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++){
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
    }
}
