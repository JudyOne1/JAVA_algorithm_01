package dynamic;

public class leetcode516 {
    public int longestPalindromeSubseq1(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        return dp1(s, reverseS);
    }

    private int dp1(String s, String reverseS) {
        char[] c1 = s.toCharArray();
        char[] c2 = reverseS.toCharArray();
        int n = c1.length;
        int m = c2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];

    }

    //先将s反转得到t，然后这道题目就转化为1143最长公共子序列
    public int longestPalindromeSubseq(String s) {
        String sReverse = new StringBuilder(s).reverse().toString();
        return dp(s, sReverse);
    }

    public int dp(String text1, String text2) {
        char[] s = text1.toCharArray(), t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s[i] == t[j]) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }
        return f[n][m];
    }
}
