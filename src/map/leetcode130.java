package map;

public class leetcode130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 创建一个辅助矩阵用于标记已经访问过的陆地
        boolean[][] visited = new boolean[rows][cols];

        // 遍历边缘陆地并进行标记
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfsO(board, i, 0, visited);
            }
            if (board[i][cols - 1] == 'O' && !visited[i][cols - 1]) {
                dfsO(board, i, cols - 1, visited);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfsO(board, 0, j, visited);
            }
            if (board[rows - 1][j] == 'O' && !visited[rows - 1][j]) {
                dfsO(board, rows - 1, j, visited);
            }
        }

        // 遍历内部陆地并进行替换
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    dfsX(board, i, j, visited);
                }
            }
        }
    }

    // 使用深度优先搜索遍历岛屿并标记所有相连的陆地为水域
    private void dfsO(char[][] board, int row, int col, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || board[row][col] == 'X') {
            return;
        }

        visited[row][col] = true; // 标记当前陆地为已访问

        // 递归地遍历当前陆地的上、下、左、右四个方向
        dfsO(board, row - 1, col, visited); // 上
        dfsO(board, row + 1, col, visited); // 下
        dfsO(board, row, col - 1, visited); // 左
        dfsO(board, row, col + 1, visited); // 右

    }

    private void dfsX(char[][] board, int row, int col, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || board[row][col] == 'X') {
            return;
        }

        visited[row][col] = true; // 标记当前陆地为已访问
        board[row][col] = 'X';
        // 递归地遍历当前陆地的上、下、左、右四个方向
        dfsX(board, row - 1, col, visited); // 上
        dfsX(board, row + 1, col, visited); // 下
        dfsX(board, row, col - 1, visited); // 左
        dfsX(board, row, col + 1, visited); // 右

    }
}
