package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0; // n为字符串长度，ans用于存储最长子串长度
        Map<Character, Integer> map = new HashMap<>(); // 使用HashMap存储字符及其最近出现的位置

        for (int end = 0, start = 0; end < n; end++) { // end指向当前遍历到的字符位置
            char alpha = s.charAt(end); // 当前字符
            if (map.containsKey(alpha)) { // 如果当前字符已经在HashMap中存在
                start = Math.max(map.get(alpha), start); // 更新start位置为当前字符或之前出现的同一字符的下一个位置
            }
            ans = Math.max(ans, end - start + 1); // 更新最长子串长度
            map.put(s.charAt(end), end + 1); // 更新字符的最近出现位置
        }
        return ans; // 返回最长子串长度
    }


}
