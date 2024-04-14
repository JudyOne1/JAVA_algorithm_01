package hashTable;

import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    public int longestConsecutive(int[] nums) {
        // 使用哈希集合存储数组中的所有唯一元素
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // 遍历哈希集合中的每个元素，查找最长连续序列
        for (int num : set) {
            int cur = num;
            // 如果当前数字的前一个数字不存在于集合中，则从当前数字开始向后查找连续序列
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // 更新最长连续序列的长度
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}
