package dynamic;

public class leetcode64 {
    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = grid[0][0];
        //向右，向下
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[row - 1][col - 1];
    }

    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j) {
        // 当到达目标位置时，直接返回该位置的值
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        // 当到达最后一行时，只能向右移动
        if (i == grid.length - 1) {
            return grid[i][j] + dfs(grid, i, j + 1);
        }
        // 当到达最后一列时，只能向下移动
        if (j == grid[0].length - 1) {
            return grid[i][j] + dfs(grid, i + 1, j);
        }
        // 在其他位置时，可以选择向下或向右移动，选择路径和最小的方向
        return grid[i][j] + Math.min(dfs(grid, i + 1, j), dfs(grid, i, j + 1));
    }

    public int dp(int[][] grid) {
        // 创建一个dp数组来存储路径信息，额外增加的行和列用于边界条件处理
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[0][0] = grid[0][0]; // 起始点的代价设为网格自身的值

        // 初始化第一行和第一列的代价，相当于只考虑水平或垂直方向的移动
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 动态规划填表，每个单元格的最小代价等于其上方和左方单元格最小代价之和的较小值加上自身的代价
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        // 返回右下角单元格的最小代价
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
