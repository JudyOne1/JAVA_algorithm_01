package map;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode994 {
    public int orangesRotting(int[][] grid) {
        // 验证输入的有效性
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // 初始化广度优先遍历参数
        int round = 0; // 记录腐烂橙子的轮次【分钟】
        int count = 0; // 记录新鲜橙子的数量
        Deque<int[]> que = new ArrayDeque<>(); // 存储腐烂橙子的位置【BFS】
        int[][] move = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 可以移动的方向【上下左右】

        int M = grid.length;
        int N = grid[0].length;
        // 统计新鲜橙子数量并把腐烂橙子的位置加入队列
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    //记录初始时腐烂橙子位置
                    que.add(new int[]{r, c});
                }
            }
        }
        int len = que.size(); // 当前轮次腐烂橙子的数量
        // 广度优先遍历开始
        while (!que.isEmpty()) {
            if (len == 0) {
                // 当前轮次腐烂橙子数量为0，说明当前轮次没有腐烂橙子，轮次加一，继续下一轮
                len = que.size();
                round++;
            }
            int[] cur = que.poll(); // 出队列，获取当前腐烂橙子的位置
            len--;// 当前轮次腐烂橙子数量减一
            int m = cur[0];// 当前腐烂橙子的行数
            int n = cur[1];// 当前腐烂橙子的列数
            // 遍历当前腐烂橙子的四个相邻位置
            for (int i = 0; i < 4; i++) {
                int nexty = m + move[i][0];// 计算相邻位置的行数
                int nextx = n + move[i][1];// 计算相邻位置的列数
                // 跳过越界的橙子
                if (nextx < 0 || nexty == grid.length || nexty < 0 || nextx == grid[0].length) continue;
                // 如果相邻位置是新鲜橙子，则将其腐烂，并将其位置加入队列，同时新鲜橙子数量减一
                if (grid[nexty][nextx] == 1) {
                    que.offer(new int[]{nexty, nextx});
                    grid[nexty][nextx] = 2;
                    count--;
                }
            }
        }
        // 如果还有新鲜橙子未腐烂，返回-1，否则返回腐烂的轮数
        if (count != 0) return -1;
        return round;
    }

}
