package stackAndList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class leetcode20 {
    /**
     * 检查给定字符串中的括号是否有效。
     * @param s 待检查的字符串，仅包含括号字符'(', ')', '{', '}', '[' 和 ']'
     * @return 如果字符串中的括号可以完全匹配（即每个左括号都有与之匹配的右括号），则返回true；否则返回false。
     */
    public boolean isValid(String s) {
        boolean flag=true; // 标记是否有效
        // 新建一个栈，用于存放左括号
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                // 遇到左括号，入栈
                stack.push(s.charAt(i));
            } else {
                // 遇到右括号，判断是否与栈顶元素匹配
                if (stack.isEmpty()) {
                    // 栈为空，所以没有匹配的左括号，标记为无效
                    flag = false;
                    break;
                } else if (stack.peek() == '(' && s.charAt(i) == ')'){
                    // '(' 与 ')' 匹配，出栈
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(i) == '}'){
                    // '{' 与 '}' 匹配，出栈
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(i) == ']'){
                    // '[' 与 ']' 匹配，出栈
                    stack.pop();
                }else {
                    // 遇到不匹配的括号，标记为无效
                    flag = false;
                }
            }
        }
        // 如果栈非空，说明有左括号没有匹配到对应的右括号，标记为无效
        if (!stack.isEmpty()){
            flag = false;
        }

        return flag;
    }

}
