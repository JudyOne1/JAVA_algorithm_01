package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode54 {
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int col = matrix[0].length;
        int row = matrix.length;
        //左上角x1，y1\右下角x2,y2
        circle2(matrix, 0, 0, row - 1, col - 1, list);
        return list;
    }

    private void circle2(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> list) {
        if (x1 > x2 || y1 > y2) {
            return;
        }
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                list.add(matrix[x1][i]);
            }
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                list.add(matrix[i][y1]);
            }
            return;
        }
        //右
        for (int i = y1; i < y2; i++) {
            list.add(matrix[x1][i]);
        }
        //下
        for (int i = x1; i < x2; i++) {
            list.add(matrix[i][y2]);
        }
        //左
        for (int i = y2; i > y1; i--) {
            list.add(matrix[x2][i]);
        }
        //上
        for (int i = x2; i > x1; i--) {
            list.add(matrix[i][y1]);
        }
        circle2(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, list);
    }

    public List<Integer> spiralOrder1(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        circle(mat, 0, 0, m - 1, n - 1, ans);
        return ans;
    }

    // 遍历 以 (x1, y1) 作为左上角，(x2, y2) 作为右下角形成的「圈」
    void circle(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> ans) {
        if (x2 < x1 || y2 < y1) return;
        // 只有一行时，按「行」遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
            return;
        }
        // 只有一列时，按「列」遍历
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(mat[i][y2]);
            return;
        }
        // 遍历当前「圈」
        for (int i = y1; i < y2; i++) ans.add(mat[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(mat[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(mat[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(mat[i][y1]);
        // 往里收一圈，继续遍历
        circle(mat, x1 + 1, y1 + 1, x2 - 1, y2 - 1, ans);
    }

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
