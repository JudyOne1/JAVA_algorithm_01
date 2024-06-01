package string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode32 {
    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    max = Math.max(max, stack.isEmpty() ? i - start : i - stack.peek());
                }
            }

        }
        return max;


    }


    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>(); // 用于存储左括号索引的栈
        int max = 0; // 记录最长有效括号子串的长度
        int start = 0; // 记录无效括号子串的起始索引

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // 遇到左括号，将其索引入栈
            } else {
                if (stack.isEmpty()) {
                    start = i + 1; // 栈为空，说明当前右括号无法匹配，更新起始索引
                } else {
                    stack.pop(); // 遇到右括号，匹配栈顶的左括号
                    max = Math.max(max, stack.isEmpty() ? i - start + 1 : i - stack.peek());
                    // 更新最长有效括号长度：如果栈为空，说明匹配了一个新的有效括号串；否则，计算当前有效括号长度
                }
                /**
                 * 如果栈为空，说明以当前右括号为右端点的合法括号序列的左端点为start，则更新答案 i - start + 1。
                 *
                 * 如果栈不为空，说明以当前右括号为右端点的合法括号序列的左端点为栈顶元素的下一个元素，则更新答案i - stack.peek() 。
                 */
            }
        }
        return max;
    }
}
