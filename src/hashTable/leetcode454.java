package hashTable;

import javax.swing.*;
import java.util.HashMap;

public class leetcode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 1. 先将nums1和nums2的和存入map中，key为和，value为出现次数

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        };
        // 2. 遍历nums3和nums4的和，如果map中存在该和，则为找到，否则为0
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                //因为nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
                //所以nums1[i]+nums2[j] = 0-nums3[i]-nums4[j]

                count+=map.getOrDefault(0-nums3[i]-nums4[j],0);
            }
        };

        return count;
    }
}
