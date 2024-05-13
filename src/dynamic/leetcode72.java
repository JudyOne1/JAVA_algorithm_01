package dynamic;

public class leetcode72 {
    private char[] s, t;
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        return dp(word1, word2);
    }

    public int dpM(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = i + 1;
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = s[i] == t[j] ? dp[i][j] :
                        Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
            }
        }
        return dp[n][m];
    }

    public int dp1(String text1, String text2) {
        char[] s = text1.toCharArray(), t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int j = 1; j <= m; ++j) {
            f[0][j] = j;
        }
        for (int i = 0; i < n; ++i) {
            f[i + 1][0] = i + 1;
            for (int j = 0; j < m; ++j)
                f[i + 1][j + 1] = s[i] == t[j] ? f[i][j] :
                        Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
        }
        return f[n][m];
    }

    public int dp(String text1, String text2) {
        char[] s = text1.toCharArray(), t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int j = 1; j <= m; ++j) {
            f[0][j] = j;
        }
        for (int i = 0; i < n; ++i) {
            f[i + 1][0] = i + 1;
            for (int j = 0; j < m; ++j) {
                if (s[i] == t[j]) {
                    f[i + 1][j + 1] = f[i][j];
                } else {
                    f[i + 1][j + 1] = Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
                }
            }
        }
        return f[n][m];
    }

    private int dfs(int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s[i] == t[j]) {
            return memo[i][j] = dfs(i - 1, j - 1);//相同就都去掉
        }
        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
        //                                     删除👆 去掉s[i] ; 插入👆 相当于去掉j[i] ; 相当于替换👆
    }

}
