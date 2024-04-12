package map;

public class leetcode463 {

    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        int islands = 0; // 岛屿周长
        // 双重循环遍历地图，找出所有陆地并计算周长
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands += infect(grid, i, j);
                    return islands; // 找到一块陆地后立即返回周长，简化计算
                }
            }
        }
        return islands;
    }

    public int infect(int[][] board, int i, int j) {
        // 检查当前位置是否合法以及是否为陆地，若不满足则返回周长0
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != 1) {
            return 0;
        }
        // 避免重复计算
        if (visited[i][j]) {
            return 0;
        }
        int Side = 4; // 默认陆地每边长为4
        // 检查上下左右四个方向是否为陆地，若是则减少边长
        if (i - 1 >= 0 && board[i - 1][j] == 1) {
            Side--;
        }
        if (i + 1 < board.length && board[i + 1][j] == 1) {
            Side--;
        }
        if (j - 1 >= 0 && board[i][j - 1] == 1) {
            Side--;
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 1) {
            Side--;
        }
        visited[i][j] = true; // 标记当前位置为已访问

        // 递归地计算上、下、左、右四个方向的陆地周长，并累加到当前周长
        return Side + infect(board, i - 1, j) +
                infect(board, i + 1, j) +
                infect(board, i, j - 1) +
                infect(board, i, j + 1);
    }

}
