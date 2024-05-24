package stackAndList;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class leetcode20 {
    public boolean isValid3(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }};
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            }
            else if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }

    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid1(String s) {
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                // 遇到左括号，入栈
                stack.push(cur);
            } else {
                // 遇到右括号，判断是否与栈顶元素匹配
                if (stack.isEmpty()) {
                    // 栈为空，所以没有匹配的左括号，标记为无效
                    flag = false;
                    break;
                } else if (stack.peek() == '(' && cur == ')') {
                    // '(' 与 ')' 匹配，出栈
                    stack.pop();
                } else if (stack.peek() == '{' && cur == '}') {
                    // '{' 与 '}' 匹配，出栈
                    stack.pop();
                } else if (stack.peek() == '[' && cur == ']') {
                    // '[' 与 ']' 匹配，出栈
                    stack.pop();
                } else {
                    // 遇到不匹配的括号，标记为无效
                    flag = false;
                }
            }
        }
        if (!stack.isEmpty()) {
            flag = false;
        }
        return flag;

    }

    public boolean isValid(String s) {
        boolean flag = true; // 标记是否有效
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
                } else if (stack.peek() == '(' && s.charAt(i) == ')') {
                    // '(' 与 ')' 匹配，出栈
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                    // '{' 与 '}' 匹配，出栈
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                    // '[' 与 ']' 匹配，出栈
                    stack.pop();
                } else {
                    // 遇到不匹配的括号，标记为无效
                    flag = false;
                }
            }
        }
        // 如果栈非空，说明有左括号没有匹配到对应的右括号，标记为无效
        if (!stack.isEmpty()) {
            flag = false;
        }

        return flag;
    }

}
