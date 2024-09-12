package dynamic;

import java.util.Arrays;

public class leetcode1143 {

    public int longestCommonSubsequence2(String text1, String text2) {

    }
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int n = c1.length;
        int m = c2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];


    }


    public int longestCommonSubsequence(String text1, String text2) {
        char[] s;
        char[] t;
        int[][] cache;
        s = text1.toCharArray();
        t = text2.toCharArray();
        int n = s.length, m = t.length;
        cache = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(cache[i], -1); // -1 表示没有访问过
        return dfs(n - 1, m - 1, s, t, cache);

//        return dp(text1, text2);
    }

    public int dp1(String text1, String text2) {
        char[] s = text1.toCharArray(), t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s[i] == t[j]) {
                    //当前字符匹配，所以最长公共子序列长度加 1
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                    // 当前字符不匹配，则 dp[i][j] 等于 dp[i - 1][j] 和 dp[i][j - 1] 中的较大值，
                    // 表示最长公共子序列可能来自 text1 的前 i - 1 个字符和 text2 的前 j 个字符，
                    // 或者来自 text1 的前 i 个字符和 text2 的前 j - 1 个字符。
                }
            }
        }
        return f[n][m];
    }

    public int dpM(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }
        return f[n][m];
    }

    private int dfs(int i, int j, char[] s, char[] t, int[][] cache) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (s[i] == t[j]) {
            return cache[i][j] = dfs(i - 1, j - 1, s, t, cache) + 1;
        }
        return cache[i][j] = Math.max(dfs(i - 1, j, s, t, cache), dfs(i, j - 1, s, t, cache));
    }


    public int dp(String text1, String text2) {
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        int N = charArray1.length;
        int M = charArray2.length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = charArray1[i] == charArray2[j] ? 1 : 0;
                } else if (i == 0) {
                    dp[i][j] = charArray1[i] == charArray2[j] ? 1 : dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = charArray1[i] == charArray2[j] ? 1 : dp[i - 1][j];
                } else {
                    int p1 = dp[i][j - 1];
                    int p2 = dp[i - 1][j];
                    int p3 = charArray1[i] == charArray2[j] ? 1 + dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.max(Math.max(p1, p2), p3);
                }
            }
        }
        return dp[N - 1][M - 1];
    }

    public static int process1(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) {
            // str1[0..0]和str2[0..0]，都只剩一个字符了
            // 那如果字符相等，公共子序列长度就是1，不相等就是0
            // 这显而易见
            return str1[i] == str2[j] ? 1 : 0;
        } else if (i == 0) {
            // 这里的情况为：
            // str1[0...0]和str2[0...j]，str1只剩1个字符了，但是str2不只一个字符
            // 因为str1只剩一个字符了，所以str1[0...0]和str2[0...j]公共子序列最多长度为1
            // 如果str1[0] == str2[j]，那么此时相等已经找到了！公共子序列长度就是1，也不可能更大了
            // 如果str1[0] != str2[j]，只是此时不相等而已，
            // 那么str2[0...j-1]上有没有字符等于str1[0]呢？不知道，所以递归继续找
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i, j - 1);
            }
        } else if (j == 0) {
            // 和上面的else if同理
            // str1[0...i]和str2[0...0]，str2只剩1个字符了，但是str1不只一个字符
            // 因为str2只剩一个字符了，所以str1[0...i]和str2[0...0]公共子序列最多长度为1
            // 如果str1[i] == str2[0]，那么此时相等已经找到了！公共子序列长度就是1，也不可能更大了
            // 如果str1[i] != str2[0]，只是此时不相等而已，
            // 那么str1[0...i-1]上有没有字符等于str2[0]呢？不知道，所以递归继续找
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i - 1, j);
            }
        } else { // i != 0 && j != 0
            // 这里的情况为：
            // str1[0...i]和str2[0...i]，str1和str2都不只一个字符
            // 看函数开始之前的注释部分
            // p1就是可能性c) 【完全不考虑i位置，可以考虑j位置】
            int p1 = process1(str1, str2, i - 1, j);

            // p2就是可能性b) 【可以考虑i位置，完全不考虑j位置】
            int p2 = process1(str1, str2, i, j - 1);

            // p3就是可能性d)，如果可能性d)存在，即str1[i] == str2[j]，那么p3就求出来，参与pk
            // 如果可能性d)不存在，即str1[i] != str2[j]，那么让p3等于0，然后去参与pk，反正不影响
            // 【必须考虑i和j位置，要求i和j位置的字符一定要相等】
            int p3 = str1[i] == str2[j] ? (1 + process1(str1, str2, i - 1, j - 1)) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

}
