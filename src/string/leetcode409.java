package string;

public class leetcode409 {
    public int longestPalindrome(String s) {
        int[] str = new int[52];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                str[s.charAt(i) - 'a']++;
            } else {
                str[26 + s.charAt(i) - 'A']++;
            }
        }
        boolean single = false;
        for (int i = 0; i < str.length; i++) {
            res += str[i] / 2 * 2;
            if (str[i] % 2 == 1) {
                single = true;
            }
        }
        return res + (single ? 1 : 0);
    }
}
