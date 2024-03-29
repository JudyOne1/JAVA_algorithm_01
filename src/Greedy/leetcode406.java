package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        //[h我们身高，k前面有几个比我高+一样高的哥们],乱序的数组根据条件排序
        //先根据身高来开学，由高到低，再根据条件进行插入

        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) { // a - b 是升序排列，故在a[0] == b[0]的状况下，会根据k值升序排列
                return a[1] - b[1];
            }
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的状况会根据h值降序排列
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1], p);   //将value插入到指定index里，k作为index
        }

        return que.toArray(new int[people.length][]);
    }
}
