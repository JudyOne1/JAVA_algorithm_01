package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        Integer[] res = new Integer[(r + 1) * (b + 1)];
        // 按螺旋顺序遍历矩阵
        while (true) {
            // 从左到右遍历上边界
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if (++t > b) break; // 如果上边界已经遍历完，结束循环

            // 从上到下遍历右边界
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if (l > --r) break; // 如果右边界已经遍历完，结束循环

            // 从右到左遍历下边界
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if (t > --b) break; // 如果下边界已经遍历完，结束循环

            // 从下到上遍历左边界
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if (++l > r) break; // 如果左边界已经遍历完，结束循环
        }
        return Arrays.asList(res);
    }
}
