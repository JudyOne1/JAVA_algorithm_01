package hashTable;

import java.util.HashSet;
import java.util.Set;

public class leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //使用set分别保存num1和num2，利用java原始api取交集，交集转换为数组返回即可
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }
}
