package Greedy;

import java.util.*;

/**
 * 合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class leetcode56 {

    public int[][] merge5(int[][] intervals) {
        if (intervals == null){
            return new int[0][2];
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] inside = list.get(list.size() - 1);
            if (inside[1] >= cur[0]){
                inside[1] = Math.max(inside[1],cur[1]);
            }else {
                list.add(cur);
            }
        }

        return list.toArray(new int[list.size()][]);
    }





    public int[][] merge4(int[][] intervals) {

        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (result.getLast()[1] >= intervals[i][0]){
                int start = result.getLast()[0];
                int end = Math.max(intervals[i][1], result.getLast()[1]);
                result.removeLast();
                result.add(new int[]{start,end});
            }else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);



 /*       LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                //可以合并
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{start, end});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);*/
    }


    public int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int n = intervals.length;
        int[][] mergeArray = new int[n][2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            int curleft = intervals[i][0];
            int curright = intervals[i][1];
            if (index != -1) {
                int mergeleft = mergeArray[index][0];
                int mergeright = mergeArray[index][1];
                if (mergeright >= curleft) {
                    mergeright = Math.max(mergeright, curright);
                    mergeArray[index][1] = mergeright;
                } else {
                    mergeArray[++index] = new int[]{curleft, curright};
                    index++;
                }
            } else {
                mergeArray[++index] = new int[]{curleft, curright};
            }
        }
        return Arrays.copyOf(mergeArray, index + 1);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public int[][] merge1(int[][] intervals) {

        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{start, end});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        // 使用链表存储合并后的结果，方便动态添加和删除区间
        LinkedList<int[]> res = new LinkedList<>();
        // 按照区间的起始位置对区间数组进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 添加第一个区间到结果链表中
        res.add(intervals[0]);

        // 遍历排序后的区间数组，从第二个区间开始合并
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的起始位置小于等于结果链表中最后一个区间的结束位置，则进行合并
            if (intervals[i][0] <= res.getLast()[1]) {
                // 计算合并后的起始位置和结束位置
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                // 从结果链表中移除最后一个区间，并添加合并后的区间
                res.removeLast();
                res.add(new int[]{start, end});
            } else {
                // 如果当前区间无法与结果链表中的最后一个区间合并，则直接添加到结果链表的末尾
                res.add(intervals[i]);
            }
        }
        // 将链表转换为数组并返回
        return res.toArray(new int[res.size()][]);
    }
}
