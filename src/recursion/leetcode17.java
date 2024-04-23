package recursion;

import javafx.collections.transformation.SortedList;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class leetcode17 {
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        // 如果输入字符串为空，直接返回空结果列表
        if (digits.isEmpty()) {
            return result;
        }
        // 数字到字母的映射数组
        String[] numStrMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String str = "";
        dfs(digits,numStrMap,result,str,0);
        return result;
    }

    private void dfs(String digits, String[] numStrMap, LinkedList<String> result, String str, int index) {
        if (index == digits.length()){
            result.add(str);
            return;
        }
        String numberStr = numStrMap[digits.charAt(index) - '0'];
        for (int i = 0; i < numberStr.length(); i++) {
            str += numberStr.charAt(i);
            dfs(digits,numStrMap,result,str,index+1);
            str = str.substring(0,str.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        // 如果输入字符串为空，直接返回空结果列表
        if (digits.length() == 0) {
            return result;
        }
        // 数字到字母的映射数组
        String[] numStrMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String str = "";
        // 开始处理字母组合
        process(numStrMap, digits, 0, result, str);
        return result;
    }


    private void process(String[] numStrMap, String digits, int index, LinkedList<String> result, String str) {
        // 当构建的字母组合长度等于数字字符串长度时，加入结果列表
        if (str.length() == digits.length()) {
            result.add(str);
            return;
        }
        // 获取当前数字对应的字母集合
        String numberStr = numStrMap[digits.charAt(index) - '0'];
        for (int i = 0; i < numberStr.length(); i++) {
            // 将当前字母添加到构建的字符串中，然后递归处理下一个数字
            str += numberStr.charAt(i);
            process(numStrMap, digits, index + 1, result, str);
            // 回溯，移除最后一个添加的字母，继续下一个可能的字母组合
            str = str.substring(0, str.length() - 1);
        }
    }
}
