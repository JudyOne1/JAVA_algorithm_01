package recursion;

import java.util.LinkedList;
import java.util.List;

public class leetcode93 {
    /**
     * 根据给定的字符串s，恢复所有的IP地址。
     *
     * @param s 给定的字符串，代表一个可能的IP地址。
     * @return 所有可能的IP地址列表，以字符串列表形式返回。
     */
    public List<String> restoreIpAddresses(String s) {
        // 初始化结果列表
        LinkedList<String> result = new LinkedList<>();
        // 长度不符合IP地址基本要求的直接返回空列表
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        // 初始化路径、分割点、点的数量，用于递归过程中的状态记录
        String path = "";
        int split = 0;
        int dotNumber = 0;
        // 启动递归处理
        process(s, split, result, path, dotNumber);
        return result;
    }

    /**
     * 递归处理字符串s，尝试所有可能的分割方式，以恢复IP地址。
     *
     * @param s 当前处理的字符串片段。
     * @param split 当前的分割点位置。
     * @param result 存放结果的列表。
     * @param path 当前构建的IP地址路径。
     * @param dotNumber 当前已经存在的点的数量。
     */
    private void process(String s, int split, LinkedList<String> result, String path, int dotNumber) {
        // 成功构建四个段，且点数正确，加入结果列表
        if (split == s.length() && dotNumber == 4) {
            result.add(path);
            return;
        } else if (dotNumber > 4 || split > s.length()) {
            // 点数超过限制或分割位置超过字符串长度，递归终止
            return;
        }
        // 尝试所有可能的分割长度
        for (int i = 1; i <= Math.min(3, s.length() - split); i++) {
            String substring = s.substring(split, split + i);
            // 检查子串是否符合段的要求：长度0-255，且如果不是两位数，不能以0开头
            if (Integer.parseInt(substring) <= 255 && ((substring.length() > 1 && substring.charAt(0) != '0') || substring.length() == 1)) {
                // 如果当前已经是第三个点，则在后面添加最后一个段，否则添加一个点
                if (dotNumber == 3) {
                    process(s, split + i, result, path + substring, ++dotNumber);
                    dotNumber--;
                } else {
                    process(s, split + i, result, path + substring + ".", ++dotNumber);
                    dotNumber--;
                }
            }
        }
    }
}
