package Greedy;

import java.util.*;

public class leetcode763 {
    /**
     * 对字符串进行分割，返回每个分割区间的长度。
     *
     * @param s 输入的字符串
     * @return 分割区间的长度列表
     */
    public List<Integer> partitionLabels(String s) {
        int[][] partitions = findPartitions(s); // 查找每个字符的区间
        List<Integer> res = new ArrayList<>();
        Arrays.sort(partitions, (o1, o2) -> Integer.compare(o1[0], o2[0])); // 按照起始位置排序
        int right = partitions[0][1]; // 当前分割区间的右边界
        int left = 0; // 当前分割区间的左边界

        // 遍历分区，计算每个分割区间的长度
        for (int i = 0; i < partitions.length; i++) {
            if (partitions[i][0] > right) {
                // 当前分区的起始位置大于右边界，表示完成了一次分割
                res.add(right - left + 1);
                left = partitions[i][0];
            }
            right = Math.max(right, partitions[i][1]); // 更新右边界
        }
        // 添加最右端的分割区间长度
        res.add(right - left + 1);
        return res;
    }
    /**
     * 查找字符串的分区。该方法会将字符串中每个字符出现的区间记录下来。
     *
     * @param s 输入的字符串
     * @return 一个二维数组，其中每个子数组表示一个字符的出现区间[起始位置，结束位置]
     */
    public int[][] findPartitions(String s) {
        List<Integer> temp = new ArrayList<>();
        int[][] hash = new int[26][2]; // 26个字母2列，表示每个字母对应的区间

        // 遍历字符串，更新每个字符的区间
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 更新字符c对应的区间位置
            if (hash[c - 'a'][0] == 0) hash[c - 'a'][0] = i;
            hash[c - 'a'][1] = i;

            // 初始化第一个字符的起始位置为0
            hash[s.charAt(0) - 'a'][0] = 0;
        }

        List<List<Integer>> h = new LinkedList<>();
        // 组装区间
        for (int i = 0; i < 26; i++) {
            temp.clear();
            temp.add(hash[i][0]);
            temp.add(hash[i][1]);
            h.add(new ArrayList<>(temp));
        }

        int[][] res = new int[h.size()][2];
        // 将区间列表转换为数组
        for (int i = 0; i < h.size(); i++) {
            List<Integer> list = h.get(i);
            res[i][0] = list.get(0);
            res[i][1] = list.get(1);
        }

        return res;
    }



    public static void main(String[] args) {
        new leetcode763().partitionLabels("ababcbacadefegdehijhklij");
    }
}
