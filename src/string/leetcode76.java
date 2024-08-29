package string;

import java.util.*;

public class leetcode76 {
    public String minWindow2(String s, String t) {

        int len = s.length();
        int ansLeft = -1;
        int ansRight = len;
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        int left = 0;
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        for (int right = 0; right < len; right++) {
            cntS[s.charAt(right)]++;
            while (isCovered(cntS, cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[s.charAt(left)]--;
                left++;
            }
        }

        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }


    public String minWindow(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1; // 最短子串的左边界初始设置为-1
        int ansRight = m; // 最短子串的右边界初始设置为字符串S的长度
        int left = 0; // 子串的左指针
        int[] cntS = new int[128]; // 统计字符串S中字符出现的次数
        int[] cntT = new int[128]; // 统计目标字符串t中字符出现的次数

        // 初始化目标字符串t中字符的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        // 移动子串的右端点
        for (int right = 0; right < m; right++) {
            cntS[s[right]]++; // 将当前字符计入子串的统计中

            // 当子串包含了目标字符串t的所有字符时
            while (isCovered(cntS, cntT)) {
                // 如果当前子串比之前找到的最短子串更短
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left; // 更新最短子串的左边界
                    ansRight = right; // 更新最短子串的右边界
                }
                cntS[s[left++]]--; // 将左指针指向的字符从子串统计中移出
            }
        }
        // 如果未找到包含目标字符串t的子串，则返回空字符串
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }


    public String minWindow1(String s, String t) {
        // 如果源字符串长度小于目标字符串长度，直接返回空字符串
        if (s.length() < t.length()) {
            return "";
        }
        String res = ""; // 初始化结果字符串
        int left = 0, right = 0, count = Integer.MAX_VALUE; // 初始化指针和最小子串长度

        // 遍历字符串s
        while (right < s.length()) {
            String substring = s.substring(left, right + 1); // 获取当前子串
            // 判断当前子串是否覆盖了目标字符串t
            if (isCovered1(substring, t)) {
                // 如果当前子串长度小于记录的最小子串长度，更新最小子串长度和结果字符串
                if (substring.length() < count) {
                    count = substring.length();
                    res = substring;
                }
                left++; // 左指针右移，继续寻找下一个可能的子串
            } else {
                right++; // 如果当前子串未覆盖目标字符串t，右指针右移，扩展子串
            }
        }

        return res; // 返回最短子串
    }

    public boolean isCovered1(String substring, String target) {
        int[] allCharCounts = new int[Character.MAX_VALUE];
        for (char c : substring.toCharArray()) {
            allCharCounts[c]++;
        }

        for (char c : target.toCharArray()) {
            if (--allCharCounts[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode76().minWindow1("ADOBECODEBANC", "ABC");
    }

}
