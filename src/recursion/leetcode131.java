package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode131 {
    public List<List<String>> partition1(String s) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        int index = 0;
        dfs(result, path, s, index);
        return result;
    }

    private void dfs(List<List<String>> result, LinkedList<String> path, String s, int index) {
        if (index == s.length()) { // 如果已经处理到字符串末尾，将当前路径添加到结果中
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) { // 尝试所有可能的子串
            String substring = s.substring(index, i + 1); // 获取当前子串
            if (isPalindrome(substring)) { // 如果子串是回文串
                path.add(substring); // 加入当前路径
                dfs(result, path, s, i + 1); // 递归处理下一个字符
                path.removeLast(); // 回溯，移除当前子串
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>(); // 当前路径，存储当前正在构建的回文串组合
        int index = 0; // 当前处理的字符索引
        process(s, index, path, result); // 开始处理字符串
        return result; // 返回结果
    }


    private void process(String s, int index, LinkedList<String> path, List<List<String>> result) {
        if (index == s.length()) { // 如果已经处理到字符串末尾，将当前路径添加到结果中
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) { // 尝试所有可能的子串
            String substring = s.substring(index, i + 1); // 获取当前子串
            if (isPalindrome(substring)) { // 如果子串是回文串
                path.add(substring); // 加入当前路径
                process(s, i + 1, path, result); // 递归处理下一个字符
                path.removeLast(); // 回溯，移除当前子串
            }
        }
    }


    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) { // 双指针法检查回文
            if (s.charAt(left) != s.charAt(right)) {
                return false; // 如果左右字符不等，不是回文串
            }
            left++;
            right--;
        }
        return true; // 字符串是回文串
    }
}
