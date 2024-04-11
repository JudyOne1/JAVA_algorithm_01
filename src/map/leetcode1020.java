package map;

public class leetcode1020 {
    public int numEnclaves(int[][] grid) {
        int islandSize = 0; // 岛屿数量计数器
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                //边缘清零
                infect(grid, i, 0);
            }
            if (grid[i][grid[0].length-1] == 1) {
                //边缘清零
                infect(grid, i, grid[0].length-1);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1) {
                //边缘清零
                infect(grid, 0, j);
            }
            if (grid[grid.length-1][j] == 1) {
                //边缘清零
                infect(grid, grid.length-1, j);
            }
        }
        // 双重循环遍历地图
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                // 如果当前位置是陆地，则增加岛屿数量，并感染（标记为'0'）所有与之相连的陆地
                if (grid[i][j] == 1) {
                    islandSize += infect(grid, i, j);
                }
            }
        }
        return islandSize;
    }


    public  int infect(int[][] grid, int i, int j) {
        // 检查当前位置是否合法以及是否为陆地，若不满足则返回
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0; // 将当前位置的陆地标记为海
        // 递归地感染当前位置的上、下、左、右四个方向的陆地
        int p1 = infect(grid, i - 1, j);
        int p2 = infect(grid, i + 1, j);
        int p3 = infect(grid, i, j - 1);
        int p4 = infect(grid, i, j + 1);
        return 1 + p1 + p2 + p3 + p4;
    }
}
