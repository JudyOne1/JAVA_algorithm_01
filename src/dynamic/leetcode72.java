package dynamic;

public class leetcode72 {
    private char[] s, t;
    private int[][] memo;

    public int minDistance3(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (charArray1[i-1] == charArray2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.max(dp[i][j],dp[i][j]),dp[i][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int minDistance(String word1, String word2) {
        return dp(word1, word2);
    }

    /**
     * 如果 s 是空字符串，将 s 转换为 t 的前 j 个字符需要 j 步操作（插入 j 个字符），因此 f[0][j] = j。
     * 如果 t 是空字符串，将 s 的前 i 个字符转换为空字符串需要 i 步操作（删除 i 个字符），因此 f[i][0] = i。
     * <p>
     * 对于每个 i 和 j，根据当前字符是否相等来决定状态转移。
     * 如果 s[i - 1] 和 t[j - 1] 相等，则不需要编辑操作，直接从前一个状态继承：f[i][j] = f[i - 1][j - 1]。
     * 如果 s[i - 1] 和 t[j - 1] 不等，则需要考虑三种编辑操作中的最小值：
     * f[i - 1][j]：删除 s 中的一个字符。
     * f[i][j - 1]：在 s 中插入一个字符。
     * f[i - 1][j - 1]：替换 s 中的一个字符。
     *
     * @param text1
     * @param text2
     * @return
     */
    public int dp3(String text1, String text2) {
        char[] s = text1.toCharArray(); // 将字符串text1转换为字符数组s
        char[] t = text2.toCharArray(); // 将字符串text2转换为字符数组t
        int n = s.length; // 获取字符串text1的长度
        int m = t.length; // 获取字符串text2的长度
        int[][] f = new int[n + 1][m + 1]; // 创建一个(n+1)×(m+1)的二维数组f，用于存储中间结果

        // 初始化二维数组的第一行，表示将空字符串转换为任意字符串t所需的编辑操作次数
        for (int i = 0; i <= n; i++) {
            f[i][0] = i; // 从空字符串到字符串t，需要进行i次插入操作
        }

        // 初始化二维数组的第一列，表示将任意字符串s转换为空字符串所需的编辑操作次数
        for (int j = 0; j <= m; j++) {
            f[0][j] = j; // 从字符串s到空字符串，需要进行j次删除操作
        }

        // 遍历字符数组s和t，计算从s到t的编辑距离
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i - 1] == t[j - 1]) {
                    // 如果当前字符相同，不需要编辑操作，距离与左上角的值相同
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    // 如果当前字符不同，考虑三种可能的操作：
                    // 1. 插入：在s中插入一个字符，使其与t相同，编辑距离为上方的值加1
                    // 2. 删除：从s中删除一个字符，使其与t相同，编辑距离为左方的值加1
                    // 3. 替换：将s中的字符替换为t中的字符，编辑距离为左上角的值加1
                    // 取三种操作中的最小值
                    f[i][j] = 1 + Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]);
                }
            }
        }

        // 返回二维数组右下角的值，即从字符串text1到字符串text2的编辑距离
        return f[n][m];
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
