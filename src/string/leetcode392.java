package string;

public class leetcode392 {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0, j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    // 若已经遍历完 s ，则提前返回 true
                    return true;
                }
            }
        }
        return false;
    }
}
