package stackAndList;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class leetcode1047 {
    //跟妈祖游戏有点像，和《20. 有效的括号》也挺像的
    /**
     * 该方法用于移除字符串中的重复字符。该方法的实现原理是利用栈的特点进行处理：
     * 当遍历字符串遇到一个字符时，如果栈为空或栈顶元素与当前字符不相同，则将当前字符压入栈中；
     * 如果栈顶元素与当前字符相同，则认为遇到了重复字符，将栈顶元素出栈。
     * 最后，将栈中剩余的字符连接成字符串并返回。
     *
     * @param s 待处理的字符串
     * @return 移除重复字符后的字符串
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                // 如果栈为空或当前字符与栈顶元素不同，则将当前字符压入栈中
                stack.push(s.charAt(i));
            } else {
                // 遇到重复字符，将栈顶元素出栈
                stack.pop();
            }
        }
        // 将栈中剩余的字符构建成最终的结果字符串
        String res = "";
        for (Character c : stack) {
            res += c;
        }
        return res;
    }

}
