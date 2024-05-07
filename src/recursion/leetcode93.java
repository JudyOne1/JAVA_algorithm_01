package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode93 {
    public List<String> restoreIpAddresses1(String s) {
        // 初始化结果列表
        LinkedList<String> result = new LinkedList<>();
        // 长度不符合IP地址基本要求的直接返回空列表
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        // 初始化路径、分割点、点的数量，用于递归过程中的状态记录
        String path = "";
        int pos = 0;
        int dotNumber = 0;
        // 启动递归处理
        dfs(s, pos, result, path, dotNumber);
        return result;
    }

    private void dfs(String s, int pos, LinkedList<String> result, String path, int dotNumber) {
        if (pos == s.length() && dotNumber == 4) {
            result.add(path);
            return;
        } else if (dotNumber > 4 || pos > s.length()) {
            // 点数超过限制或分割位置超过字符串长度，递归终止
            return;
        }
        for (int i = 1; i < Math.min(3, s.length() - pos); i++) {
            String sub = s.substring(pos, pos + i);
            if (Integer.parseInt(sub) <= 255 && ((sub.length() > 1 && sub.charAt(0) != '0') || sub.length() == 1)) {
                if (dotNumber == 3) {
                    dfs(s, pos + i, result, path + sub, dotNumber + 1);
                    dotNumber--;
                } else {
                    dfs(s, pos + i, result, path + sub + ".", dotNumber + 1);
                    dotNumber--;
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        // 初始化结果列表
        LinkedList<String> result = new LinkedList<>();
        // 长度不符合IP地址基本要求的直接返回空列表
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        // 初始化路径、分割点、点的数量，用于递归过程中的状态记录
        String path = "";
        int pos = 0;
        int dotNumber = 0;
        // 启动递归处理
        process(s, pos, result, path, dotNumber);
        return result;
    }

    private void process(String s, int pos, LinkedList<String> result, String path, int dotNumber) {
        // 成功构建四个段，且点数正确，加入结果列表
        if (pos == s.length() && dotNumber == 4) {
            result.add(path);
            return;
        } else if (dotNumber > 4 || pos > s.length()) {
            // 点数超过限制或分割位置超过字符串长度，递归终止
            return;
        }
        // 尝试所有可能的分割长度
        for (int i = 1; i <= Math.min(3, s.length() - pos); i++) {
            String substring = s.substring(pos, pos + i);
            // 检查子串是否符合段的要求：长度0-255，且如果不是两位数，不能以0开头
            if (Integer.parseInt(substring) <= 255 && ((substring.length() > 1 && substring.charAt(0) != '0') || substring.length() == 1)) {
                // 如果当前已经是第三个点，则在后面添加最后一个段，否则添加一个点
                if (dotNumber == 3) {
                    process(s, pos + i, result, path + substring, ++dotNumber);
                    dotNumber--;
                } else {
                    process(s, pos + i, result, path + substring + ".", ++dotNumber);
                    dotNumber--;
                }
            }
        }
    }
}
