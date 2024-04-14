package stackAndList;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode150 {
    /**
     * 根据逆波兰表达式计算结果。
     *
     * @param tokens 逆波兰表达式中的单词或操作数数组。
     * @return 计算得到的结果。
     */
    public int evalRPN(String[] tokens) {
        // 使用双端队列模拟栈
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            // 遇到操作符时，进行相应的操作
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                // 对于减法，等价于加负数
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                // 注意除法的处理，先弹出第二个操作数
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                // 遇到操作数，转换为整数后入栈
                stack.push(Integer.valueOf(s));
            }
        }
        // 最后栈中剩余的即为计算结果
        return stack.pop();
    }
}
