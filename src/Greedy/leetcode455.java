package Greedy;

import java.util.Arrays;

public class leetcode455 {
    /**
     * 找到能够满足的儿童数量
     * @param g 儿童的饼干需求数组
     * @param s 饼干的大小数组
     * @return 能够满足的儿童数量
     */
    public int findContentChildren(int[] g, int[] s) {
        // 对需求和饼干大小数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0; // 记录满足的儿童数量
        int start = s.length - 1; // 从饼干数组的末尾开始匹配

        // 从需求数组的末尾开始向前遍历
        for (int index = g.length - 1; index >= 0; index--) {
            // 如果还有饼干可供分配，并且当前儿童的需求小于等于当前饼干的大小
            if(start >= 0 && g[index] <= s[start]) {
                start--; // 饼干分配给当前儿童，移动到下一个饼干
                count++; // 满足的儿童数量加一
            }
        }
        return count;
    }

}
