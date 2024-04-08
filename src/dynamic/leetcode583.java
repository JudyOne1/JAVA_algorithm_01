package dynamic;

public class leetcode583 {
    public int minDistance(String word1, String word2) {
        //最大公共子序列
        int sameWordSize = dp1(word1, word2);
        return word1.length() + word2.length() - 2 * sameWordSize;
    }
    public int dp1(String text1, String text2) {
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
