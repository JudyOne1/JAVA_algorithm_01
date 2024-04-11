package map;

public class leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        int islandSize = 0; // 岛屿大小计数器
        // 双重循环遍历地图
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前位置是陆地，则增加岛屿数量，并感染（标记为'0'）所有与之相连的陆地
                if (grid[i][j] == 1) {
                    islandSize = Math.max(infect(grid, i, j),islandSize);
                }
            }
        }
        return islandSize;
    }

    public  int infect(int[][] board, int i, int j) {
        // 检查当前位置是否合法以及是否为陆地，若不满足则返回
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != 1) {
            return 0;
        }
        board[i][j] = 0; // 将当前位置的陆地标记为海
        // 递归地感染当前位置的上、下、左、右四个方向的陆地
        int p1 = infect(board, i - 1, j);
        int p2 = infect(board, i + 1, j);
        int p3 = infect(board, i, j - 1);
        int p4 = infect(board, i, j + 1);
        return 1 + p1 + p2 + p3 + p4;
    }

    public static void main(String[] args) {
        new leetcode695().maxAreaOfIsland(new int[][]{ { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0,1,1,0,1,0,0,0,0,0,0,0,0}});
    }
}
