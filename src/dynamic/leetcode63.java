package dynamic;

public class leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return process(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }


    public int dp(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // 地图的行数
        int n = obstacleGrid[0].length; // 地图的列数
        int[][] dp = new int[m][n]; // 用于存储路径数量的二维数组

        // 遍历地图，计算每个位置的路径数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置有障碍物，则路径数量为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 初始化起点的路径数量为1
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                // 计算其他位置的路径数量
                // 如果在第一行，则只能从左边到达，路径数量等于左边位置的路径数量
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                // 如果在第一列，则只能从上边到达，路径数量等于上边位置的路径数量
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // 如果既不在第一行也不在第一列，则路径数量等于上方位置和左方位置路径数量之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回终点的路径数量
        return dp[m - 1][n - 1];
    }


    //超出时间限制
    public int process(int[][] obstacleGrid, int m, int n) {
        //数组要注意边界
        if (m < 0 || n < 0) {
            return 0;
        }
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }

        return process(obstacleGrid, m - 1, n) + process(obstacleGrid, m, n - 1);
    }
}
