package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 将目标字符串转换为字符数组并排序，以便之后比较
        char[] targetChars = p.toCharArray();
        Arrays.sort(targetChars);
        p = new String(targetChars);

        // 将源字符串转换为字符数组
        char[] sourceChars = s.toCharArray();
        int targetSize = targetChars.length; // 目标字符串长度
        List<Integer> ans = new ArrayList<>(); // 用于存储结果的列表

        char[] subChars;
        String subStr;
        // 遍历源字符串，寻找与目标字符串长度相等的子字符串
        for (int i = 0; i < sourceChars.length; i++) {
            // 如果剩余字符长度小于目标字符串长度，结束循环
            if (i + targetSize > sourceChars.length) {
                break;
            }
            // 将当前子字符串复制到数组中并排序
            subChars = new char[targetSize];
            System.arraycopy(sourceChars, i, subChars, 0, targetSize);
            Arrays.sort(subChars);
            subStr = new String(subChars);

            // 比较排序后的子字符串与目标字符串是否相等
            if (subStr.equals(p)) {
                ans.add(i); // 如果相等，将子字符串的开始位置添加到结果列表中
            }
        }
        return ans;
    }
}
