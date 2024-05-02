package dynamic;

public class leetcode647 {
    /**
     * 当只有一个字符时，比如 a 自然是一个回文串。
     * 当有两个字符时，如果是相等的，比如 aa，也是一个回文串。
     * 当有三个及以上字符时，比如 ababa 这个字符记作串 1，把两边的 a 去掉，
     * 也就是 bab 记作串 2，可以看出只要串2是一个回文串，
     * 那么左右各多了一个 a 的串 1 必定也是回文串。所以当 s[i]==s[j] 时，
     * 自然要看 dp[i+1][j-1] 是不是一个回文串。
     * @param s
     * @return
     */
    public int countSubstrings11(String s) {
        // 初始化动态规划数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0; // 记录回文子串数量

        // 双重循环遍历所有子串
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                // 判断当前子串是否为回文
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true; // 标记当前子串为回文
                    ans++; // 增加回文子串数量
                }
            }
        }

        return ans; // 返回回文子串数量
    }

    public int countSubstrings1(String s) {
        // 中心扩展法
        // 初始化回文子串计数
        int ans = 0;
        // 遍历所有可能的中心点
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // 根据中心点计算左右指针的位置
            int left = center / 2;
            int right = left + center % 2;

            // 向外扩展，检查是否为回文子串
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++; // 找到一个回文子串
                left--; // 左指针向左移动
                right++; // 右指针向右移动
            }
        }
        return ans;
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
