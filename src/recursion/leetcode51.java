package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode51 {
    private int n; // 棋盘的大小
    private int[] col; // 记录每一行放置的皇后所在的列
    private boolean[] onPath, diag1, diag2; // 标记当前行的列以及两条对角线上是否已放置了皇后
    private final List<List<String>> ans = new ArrayList<>(); // 存储所有合法的放置方案

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new int[n];
        onPath = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];
        dfs(0); // 深度优先搜索放置皇后
        return ans; // 返回所有找到的解决方案
    }

    private void dfs(int r) {
        // 如果已经尝试放置了所有的皇后（即r等于n），则将当前解决方案添加到结果列表中
        if (r == n) {
            List<String> board = new ArrayList<>(n);
            //生成棋盘状态
            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q'; // 在当前位置放置皇后
                board.add(new String(row)); // 将当前行转换为字符串并添加到解决方案中
            }
            ans.add(board); // 将当前棋盘状态添加到最终答案中
            return;
        }
        // 遍历当前行的每一列，尝试放置皇后
        for (int c = 0; c < n; ++c) {
            int rc = r - c + n - 1;//不加n-1会是负数
            // 当前位置可以放置皇后（即没有冲突）
            if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                col[r] = c; // 在当前行的当前位置放置皇后
                onPath[c] = diag1[r + c] = diag2[rc] = true; // 标记当前位置及其对应的列和对角线为已使用
                dfs(r + 1); // 递归到下一行继续放置皇后
                // 回溯：撤销当前位置及其对应的列和对角线的标记
                onPath[c] = diag1[r + c] = diag2[rc] = false;
            }
        }
    }

    class Nqueens {
        List<List<String>> ans = new ArrayList<>(); // 存储所有合法的解决方案
        int[] col; // 记录每一行皇后所在的列
        int n; // 棋盘的大小

        public List<List<String>> solveNQueens(int n) {
            col = new int[n];
            this.n = n;
            dfs(0); // 从第一行开始搜索
            return ans;
        }

        private void dfs(int r) {
            if (r == n) { // 找到一个解决方案
                List<String> tmp = new ArrayList<>();
                for (int i : col) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.'); // 初始化为空棋盘
                    row[i] = 'Q'; // 放置皇后
                    tmp.add(new String(row));
                }
                ans.add(tmp); // 添加到结果集中
                return;
            }

            for (int c = 0; c < col.length; c++) { // 尝试在当前行的每一列放置皇后
                if (valid(r, c)) { // 如果合法，则递归搜索下一行
                    col[r] = c;
                    dfs(r + 1);
                }
            }
        }

        private boolean valid(int r, int c) {
            for (int R = 0; R < r; R++) { // 检查上方和斜上方是否有皇后
                int C = col[R];
                if ((c == C) || ((R + C) == (r + c)) || ((R - C) == (r - c))) // 如果有冲突，返回 false
                    return false;
            }
            return true; // 无冲突，位置合法
        }

    }

}
