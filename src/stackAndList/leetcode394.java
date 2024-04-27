package stackAndList;

import java.util.LinkedList;
import java.util.Stack;

public class leetcode394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder(); // 用于构建解码后的字符串
        int multi = 0; // 用于存储当前字符前的数字，代表重复次数
        LinkedList<Integer> stack_multi = new LinkedList<>(); // 用于存储遇到的重复次数
        LinkedList<String> stack_res = new LinkedList<>(); // 用于存储中间解码结果

        for (Character c : s.toCharArray()) { // 遍历字符串中的每个字符
            if (c == '[') {
                // 遇到左括号，将当前的重复次数和中间结果入栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // 重置重复次数和中间结果
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 遇到右括号，根据栈中的重复次数，将当前中间结果重复多次，并与栈顶的中间结果合并
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 遇到数字，将其构成的数字串解析为整数，更新重复次数
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                // 遇到字母或其他非数字非括号字符，直接添加到中间结果
                res.append(c);
            }
        }
        return res.toString(); // 返回最终解码后的字符串
    }
}