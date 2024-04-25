package map;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode994 {
    public int orangesRotting(int[][] grid) {
        //广度优先遍历
        int min = 0;
        Deque<int[]> que = new ArrayDeque<>();
        int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 2){
                    que.offer(new int[]{i,j});
                }
            }

        }
        while (!que.isEmpty()){
            int[] cur = que.poll(); // 出队列，获取当前陆地位置
            int m = cur[0];
            int n = cur[1];
            min++;
            // 遍历当前陆地的四个相邻位置
            for(int i = 0; i < 4; i++) {
                int nexty = m + move[i][0];
                int nextx = n + move[i][1];
                if(nextx < 0 || nexty == grid.length || nexty < 0 || nextx == grid[0].length) continue;
                if(grid[nexty][nextx] == '1') {
                    que.offer(new int[]{nexty, nextx});
                    grid[nexty][nextx] = 2;
                }
            }
        }
        return min;
    }
}
