package dynamic;

public class leetcode5 {
    public String longestPalindrome3(String s) {
        int length = s.length();
        String result = "";
        for (int i = 0; i < length * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                String substring = s.substring(left, right + 1);
                if (result.length() < substring.length()) {
                    result = substring;
                }
                left--;
                right++;
            }

        }

        return result;
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        String result = "";
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String subStr = s.substring(left, right + 1);
                if (result.length() < subStr.length()) {
                    result = subStr;
                }
                left--;
                right++;
            }
        }
        return result;
    }


    public String longestPalindrome1(String s) {
        int len = s.length();
        String result = "";
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String tmp = s.substring(left, right + 1);
                if (tmp.length() > result.length()) {
                    result = tmp;
                }
                left--;
                right++;
            }
        }
        return result;
    }

    public String longestPalindrome0(String s) {
        // 初始化最长回文子串为空字符串
        int len = s.length();
        String result = "";

        // 遍历所有可能的回文子串中心，包括奇数长度和偶数长度的回文子串，要考虑到字符之间的空隙作为回文串的中心。
        for (int i = 0; i < len * 2 - 1; i++) {
            //left 和 right 分别代表回文串中心点左右两边的索引。
            // 如果 i 是偶数，那么 left 和 right 初始时指向同一个字符，即 i / 2；
            // 如果 i 是奇数，那么 left 指向 i / 2，right 指向 i / 2 + 1，即 left 和 right 分别指向中心字符的左右两边。
            int left = i / 2; // 计算回文子串的左边界
            int right = left + i % 2; // 计算回文子串的右边界
            // 扩展回文子串
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String tmp = s.substring(left, right + 1); // 获取当前回文子串
                // 更新最长回文子串
                if (tmp.length() > result.length()) {
                    result = tmp;
                }
                left--; // 左边界向左移动
                right++; // 右边界向右移动
            }
        }
        return result;
    }

    public int countSubstrings00(String s) {
        int len = s.length();
        //单个字符，每个字符都是一个回文串
        int ans = len;
        //以单个字符为中心向两侧扩散
        for (int i = 0; i < len; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        //以两个字符为中心向两侧扩散
        for (int i = 0; i < len - 1; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        int maxStart = 0; // 最长回文子串的起始位置
        int maxLength = 0; // 最长回文子串的长度

        // 遍历字符串中每个可能的回文中心，包括单个字符和两个相邻字符
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= 1; j++) {
                int l = i; // 回文左指针
                int r = i + j; // 回文右指针

                // 扩展回文串
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                // 回溯到回文字符串的起始和结束位置
                l++;
                r--;

                // 比较并保存最长的回文子串起始位置和长度
                if (maxLength < r - l + 1) {
                    maxLength = r - l + 1;
                    maxStart = l;
                }
            }
        }

        // 根据最长回文子串的起始位置和长度截取子串并返回
        return s.substring(maxStart, maxStart + maxLength);
    }

}
