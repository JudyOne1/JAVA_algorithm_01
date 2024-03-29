package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //跟射箭那题思路差不多，先排序,弓箭的数量就相当于是非交叉区间的数量
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;  // intervals 不为空至少需要一支箭
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {  // 气球i和气球i-1不挨着or气球最小右边界不挨着
                count++; // 需要一支箭
            } else {  // 气球i和气球i-1挨着
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]); // 更新重叠气球最小右边界
            }
        }
        return intervals.length-count;

    }

}
