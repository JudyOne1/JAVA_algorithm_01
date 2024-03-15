package string;

/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */

public class leetcode28 {
    /**
     * 在haystack字符串中搜索needle字符串的第一个出现位置。
     * @param haystack 主字符串，被搜索的字符串。
     * @param needle 搜索目标字符串。
     * @return 如果找到目标字符串，返回其在主字符串中的起始位置；如果没有找到，返回-1。
     */
    public int strStr(String haystack, String needle) {
        // 当主字符串与目标字符串长度相等时，直接比较两个字符串是否相等
        if (haystack.length() == needle.length()){
            if (haystack.equals(needle)){
                return 0;
            }else {
                return -1;
            }
        }
        // 使用for循环遍历主字符串，每次取与目标字符串长度相等的子串进行比较
        int length = needle.length();
        StringBuilder stringBuilder = new StringBuilder(haystack);
        for (int i = 0; i <= haystack.length()-length; i++) {
            String substring = stringBuilder.substring(i, length + i);
            if (substring.equals(needle)){
                return i;
            }
        }
        // 如果遍历完所有可能的位置都没找到目标字符串，返回-1
        return -1;
    }

}
