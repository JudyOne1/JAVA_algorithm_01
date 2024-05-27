package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        boolean[] has = new boolean[128];
        Arrays.fill(has, false);
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = chars[right];
            if (has[rightChar]) {
                while (has[rightChar]) {
                    char leftChar = chars[left];
                    has[leftChar] = false;
                    left++;
                }
            }
            has[rightChar] = true;
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        int result = 0;
        int left = 0;
        boolean[] has = new boolean[128];
        for (int right = 0; right < length; right++) {
            char rightChar = charArray[right];
            while (has[rightChar]) {
                char leftChar = charArray[left];
                has[leftChar] = false;
                left++;
            }
            has[rightChar] = true;
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组，以提高访问速度
        int n = chars.length, ans = 0, left = 0;
        boolean[] has = new boolean[128]; // 使用boolean数组来快速判断字符是否出现过，基于ASCII码，覆盖所有英文字符

        for (int right = 0; right < n; right++) {
            char rightChar = chars[right];
            // 如果当前字符已经存在于窗口内，则移动左边界，直到该字符不再存在于窗口内
            while (has[rightChar]) {
                char leftChar = chars[left];
                has[leftChar] = false; // 移除左边界字符的标记
                left++;
            }
            has[rightChar] = true; // 标记当前字符c已经存在于窗口内
            ans = Math.max(ans, right - left + 1); // 更新最长无重复字符子串的长度
        }
        return ans;
    }


}
