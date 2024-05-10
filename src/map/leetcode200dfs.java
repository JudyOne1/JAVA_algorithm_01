package map;

public class leetcode200dfs {
    public int numIslands1(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1'){
            grid[i][j] = '0';
        }else{
            return;
        }
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return;

    }

    public static int numIslands(char[][] board) {
        int islands = 0; // 岛屿数量计数器
        // 双重循环遍历地图
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 如果当前位置是陆地，则增加岛屿数量，并感染（标记为'0'）所有与之相连的陆地
                if (board[i][j] == '1') {
                    islands++;
                    infect(board, i, j);
                }
            }
        }
        return islands;
    }

    public static void infect(char[][] board, int i, int j) {
        // 检查当前位置是否合法以及是否为陆地，若不满足则返回
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != '1') {
            return;
        }
        board[i][j] = '0'; // 将当前位置的陆地标记为海
        // 递归地感染当前位置的上、下、左、右四个方向的陆地
        infect(board, i - 1, j);
        infect(board, i + 1, j);
        infect(board, i, j - 1);
        infect(board, i, j + 1);
    }
}

