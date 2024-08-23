package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode3 {

    public int lengthOfLongestSubstring4(String s) {
        boolean[] has = new boolean[128];
        Arrays.fill(has, false);
        char[] chars = s.toCharArray();
        int len = 0;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = chars[right];
            while (has[c]) {
                has[chars[start]] = false;
                start++;
            }
            has[c] = true;
            len = Math.max(len, right - start + 1);
        }
        return len;
    }


    public int lengthOfLongestSubstring3(String s) {
        //类似于滑动窗口
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int max = 0;
        int start = 0;
        boolean[] helper = new boolean[128];
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            while (helper[c]) {
                helper[charArray[start]] = false;
                start++;
            }
            helper[c] = true;
            max = Math.max(max, i - start + 1);
        }
        return max;

    }


    public int lengthOfLongestSubstring2(String s) {

        boolean[] helper = new boolean[128];
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (helper[c]) {
                helper[s.charAt(start)] = false;
                start++;
            }
            helper[c] = true;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        new leetcode3().lengthOfLongestSubstring2("pwwkew");
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
