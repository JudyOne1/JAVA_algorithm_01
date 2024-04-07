package dynamic;

import java.util.Arrays;

public class leetcode392 {

    public boolean isSubsequence(String s, String t) {

        // 如果 s 是空字符串，则任何字符串都是其子序列，返回 true
        if (s.length() == 0) return true;
        // 如果 t 是空字符串，则 s 不能是 t 的子序列，返回 false
        if (t.length() == 0) return false;
        // 如果 s 比 t 长，s 不可能是 t 的子序列，返回 false
        if (s.length() > t.length()) return false;
        // 如果 s 和 t 长度相等，只有当两个字符串相等时，s 才是 t 的子序列
        if (s.length() == t.length()) return s.equals(t);
        // 如果 s 长度为 1，只要 t 包含 s 的字符，s 就是 t 的子序列
        if (s.length() == 1) return t.indexOf(s.charAt(0)) != -1;

        // 查找 s 的第一个字符在 t 中的位置
        int first = t.indexOf(s.charAt(0));
        // 查找 s 的最后一个字符在 t 中的最后位置
        int end = t.lastIndexOf(s.charAt(s.length() - 1));
        // 如果 s 的第一个或最后一个字符在 t 中不存在，返回 false
        if (first == -1 || end == -1) return false;

        // 记录匹配的字符数量
        int count = 0;
        // 记录当前在 s 中的字符索引
        int index = 0;
        // 遍历从第一个字符到最后一个字符的范围，检查是否匹配
        for (int i = first; i <= end; i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
                count++;
            }
        }
        // 如果匹配的字符数量等于 s 的长度，返回 true，否则返回 false
        if (count == s.length()) return true;
        return false;
    }

    public boolean isSubsequence3(String s, String t) {

        // 如果s为空，任何字符串都是其子序列
        if (s.length() == 0) return true;
        // 如果t为空，s不能是t的子序列
        if (t.length() == 0) return false;
        // 如果s的长度大于t，s不能是t的子序列
        if (s.length() > t.length()) return false;
        // 如果s和t长度相等，判断s是否等于t
        if (s.length() == t.length()) return s.equals(t);
        // 如果s长度为1，判断s的字符是否在t中出现
        if (s.length() == 1) return t.indexOf(s.charAt(0)) != -1;

        // 查找s的第一个字符和最后一个字符在t中的位置
        int first = t.indexOf(s.charAt(0));
        int end = t.lastIndexOf(s.charAt(s.length() - 1));
        // 如果s的第一个或最后一个字符在t中不存在，s不能是t的子序列
        if (first == -1 || end == -1) return false;

        // 遍历从第一个字符到最后一个字符的位置，尝试在t中找到s的子序列
        for (int i = first; i <= end; i++) {
            if (t.charAt(i) == s.charAt(0)) {
                // 如果找到s的第一个字符，递归检查s的剩余部分是否是t的子序列
                if (isSubsequence(s.substring(1), t.substring(i + 1))) return true;
            }
        }
        // 如果遍历完所有可能情况都没有找到s作为子序列，返回false
        return false;
    }

}
