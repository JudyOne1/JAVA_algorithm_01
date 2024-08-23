package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode438 {
    /**
     * 先把p的字母统计出来，然后通过窗口遍历s，
     * 判断值如果小于0了，说明字母不正确/字母重复多了，左边界往右直到不小于0(剔除多的字母/不正确的字母)，
     * 不断通过窗口判断，如果窗口大小内没有小于0的问题，那么说明找到了
     */
    public List<Integer> findAnagrams4(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // 初始化一个数组来统计字符串 p 中每个字符的出现次数
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }

        // l 和 r 分别表示滑动窗口的左右边界
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // 更新当前窗口中字符的计数数组
            cnt[s.charAt(r) - 'a']--;
            // 从左侧收缩窗口，直到当前字符的计数在限定范围内
            while (cnt[s.charAt(r) - 'a'] < 0) {
                //不正确了，左边界往右移动直到正确
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            // 检查当前窗口大小是否等于字符串 p 的大小
            if (r - l + 1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }


    /**
     * 用数组模拟哈希表，在for循环中，
     * 如果右指针指向的字母对应数量小于0，
     * 左指针右移，当窗口长度等于p的长度，就进行记录。
     */
    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // 初始化一个数组来统计字符串 p 中每个字符的出现次数
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        // l 和 r 分别表示滑动窗口的左右边界
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // 更新当前窗口中字符的计数数组
            cnt[s.charAt(r) - 'a']--;
            // 从左侧收缩窗口，直到当前字符的计数在限定范围内
            while (cnt[s.charAt(r) - 'a'] < 0) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            // 检查当前窗口大小是否等于字符串 p 的大小
            if (r - l + 1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;

    }

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        // 如果字符串s的长度小于字符串p的长度，则直接返回空结果列表
        if (n < m) return res;

        // 用于统计字符串p和滑动窗口中字符的频次
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        // 初始化：统计字符串p中各字符的频次
        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }

        // 如果滑动窗口的字符频次与字符串p的字符频次相等，则将起始位置0加入结果列表
        if (Arrays.equals(sCnt, pCnt)) {
            res.add(0);
        }

        // 滑动窗口从第m个字符开始，更新字符频次并检查是否与p的字符频次相等
        for (int i = m; i < n; i++) {
            sCnt[s.charAt(i - m) - 'a']--; // 窗口左侧字符出窗口，频次减1
            sCnt[s.charAt(i) - 'a']++; // 窗口右侧字符进窗口，频次加1
            if (Arrays.equals(sCnt, pCnt)) {
                // 如果滑动窗口的字符频次与字符串p的字符频次相等，将当前位置加入结果列表
                res.add(i - m + 1);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int left = 0, right = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            // 窗口右边界右移
            right++;
            // 窗口长度大于目标字符串长度，窗口左边界右移
            if (right - left == p.length()) {
                // 窗口长度等于目标字符串长度，判断窗口内字符是否与目标字符串相同
                if (isCovered(s.substring(left, right), p)) {
                    ans.add(left);
                }
                // 窗口左边界右移
                left++;
            }
        }

        return ans;
    }

    private boolean isCovered(String substring, String p) {

        // 将字符串p转换为字符数组，并按字典序排序
        char[] targetChars = p.toCharArray();
        Arrays.sort(targetChars);
        p = new String(targetChars);

        // 将字符串substring转换为字符数组，并按字典序排序
        char[] sourceChars = substring.toCharArray();
        Arrays.sort(sourceChars);
        substring = new String(sourceChars);

        // 比较排序后的两个字符串是否相等，不相等则两个字符串不是字母异位词
        if (!substring.equals(p)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new leetcode438().findAnagrams1("baa", "aa");
    }

    public List<Integer> findAnagrams2(String s, String p) {
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
