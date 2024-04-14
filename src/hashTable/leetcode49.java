package hashTable;

import java.util.*;

public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            // 对字符数组排序，将排序后的字符数组作为key，来将相同字母异位词的字符串归为一组
            Arrays.sort(s);
            map.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());

    }
}
