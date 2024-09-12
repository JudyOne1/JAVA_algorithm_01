package dynamic;

import java.util.List;

public class leetcode139 {
    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
     * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
//        return dfs1(s, wordDict);
        return dp1(s, wordDict);
    }



    private boolean dp1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (wordDict.contains(sub)) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }


    private boolean dfs1(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (wordDict.contains(sub)) {
                if (dfs1(s.substring(i + 1), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return process(s, wordDict);
    }

    public boolean process(String s, List<String> wordDict) {
        // 当字符串为空时，分割成功，返回true
        if (s.length() == 0)
            return true;
        // 遍历字符串，尝试从每个位置切割
        for (int i = 0; i < s.length(); i++) {
            // 获取当前位置之前的子字符串
            String sub = s.substring(0, i + 1);
            // 如果子字符串在字典中存在
            if (wordDict.contains(sub)) {
                // 递归处理剩余部分，如果能分割成单词，则返回true
                if (process(s.substring(i + 1), wordDict)) {
                    return true;
                }
            }
        }
        // 如果没有找到合适的切割方式，返回false
        return false;
    }

    public boolean dp(String s, List<String> wordDict) {
        // dp数组用于记录字符串s的前i个字符是否可以由字典中的单词组成
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 空字符串可以被看作由字典中的单词组成 base case

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 尝试从字典中选取一个单词
                String sub = s.substring(j, i);
                // 如果s的前j个字符可以由字典中的单词组成，并且sub也在字典中，则s的前i个字符可由字典中的单词组成
                if (wordDict.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break; // 找到一个合适的组合后，无需继续搜索
                }
            }
        }
        // 返回字符串s是否可以由字典中的单词组成
        return dp[s.length()];
    }
}
