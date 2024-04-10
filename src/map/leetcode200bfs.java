package map;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode200bfs {
    boolean[][] visited;
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length]; // 初始化visited数组，用于标记陆地是否被访问过
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 遇到未访问的陆地，进行广度优先搜索，并将该岛屿计数
                if(!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x}); // 将起始陆地位置加入队列
        visited[y][x] = true; // 标记起始陆地为已访问
        while(!queue.isEmpty()) {
            int[] cur = queue.poll(); // 出队列，获取当前陆地位置
            int m = cur[0];
            int n = cur[1];
            // 遍历当前陆地的四个相邻位置
            for(int i = 0; i < 4; i++) {
                int nexty = m + move[i][0];
                int nextx = n + move[i][1];
                // 跳过越界的陆地或已经是水域的陆地
                if(nextx < 0 || nexty == grid.length || nexty < 0 || nextx == grid[0].length) continue;
                // 发现未访问的陆地，将其加入队列并标记为已访问
                if(!visited[nexty][nextx] && grid[nexty][nextx] == '1') {
                    queue.offer(new int[]{nexty, nextx});
                    visited[nexty][nextx] = true;
                }
            }
        }
    }

}

