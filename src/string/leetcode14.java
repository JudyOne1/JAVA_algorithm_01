package string;

public class leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        int index = 1;
        while (index <= strs[0].length()) {
            String sub = strs[0].substring(0, index);
            for (String str : strs) {
                if (!str.startsWith(sub)) {
                    return strs[0].substring(0, index - 1);
                }
            }
            index++;
        }
        return strs[0];
    }
}
