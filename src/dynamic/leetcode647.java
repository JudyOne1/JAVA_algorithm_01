package dynamic;

public class leetcode647 {
    public int countSubstrings(String s) {
        return dp(s);
    }

    public int dp(String s) {
        // 处理空字符串或空格字符串的情况
        if (s == null || s.equals("")) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp数组用于记录[i,j]区间是否为回文串
        int result = s.length(); // 初始化结果为字符串长度，因为每个字符本身都是一个回文串
        // 初始化单个字符为回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 从字符串末尾开始，依次判断所有可能的子串是否为回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 判断字符是否相等，并根据间隔的大小决定是否是回文串
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // 如果是回文串，则累加数量
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }


}
