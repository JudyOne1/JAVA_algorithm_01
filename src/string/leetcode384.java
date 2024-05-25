package string;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode384 {
    public int firstUniqChar(String s) {
        int res = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
