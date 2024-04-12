package map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 解决LeetCode第417题：太平洋大西洋水流问题。
 * 给定一个高度矩阵，判断水是否可以从太平洋流到大西洋。即，找到那些既能从顶部或底部边缘到达，也能从左侧或右侧边缘到达的位置。
 */
public class leetcode417 {
    int n, m;
    int[][] g;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 初始化变量
        g = heights;
        m = g.length;
        n = g[0].length;

        // 创建二维数组，用于标记格子是否可达太平洋或大西洋
        boolean[][] res1 = new boolean[m][n], res2 = new boolean[m][n];

        // 遍历数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 标记可达太平洋的格子
                if (i == 0 || j == 0) {
                    if (!res1[i][j]) {
                        // 可达太平洋
                        dfs(i, j, res1);
                    }
                }
                // 标记可达大西洋的格子
                if (i == m - 1 || j == n - 1) {
                    if (!res2[i][j]) {
                        // 可达大西洋
                        dfs(i, j, res2);
                    }
                }
            }
        }

        // 收集所有同时可达太平洋和大西洋的格子的坐标
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    // DFS函数，用于标记从当前格子可以到达海洋的格子
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    void dfs(int x, int y, boolean[][] res) {
        res[x][y] = true; // 标记当前格子为已访问
        // 遍历四个方向
        for (int[] di : dirs) {
            int nx = x + di[0], ny = y + di[1];
            // 跳过越界的格子和高度更低的格子
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (res[nx][ny] || g[nx][ny] < g[x][y]) continue;
            dfs(nx, ny, res); // 递归访问相邻格子
        }
    }

}

