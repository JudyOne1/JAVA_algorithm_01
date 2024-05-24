package stackAndList;

import java.util.Stack;
/**
 * 类 MinStack 实现了一个特殊的栈，该栈在支持常规栈操作（push、pop、top）的基础上，
 * 还能立即获取栈中的最小元素。
 */
class MinStack {

    private Stack<Integer> stack; // 正常的栈，用于存储所有压入的元素
    private Stack<Integer> min_stack; // 用于存储当前栈中的最小元素

    /**
     * 构造函数初始化两个栈
     */
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    /**
     * 从栈中弹出顶部元素
     */
    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    /**
     * 将元素压入栈中，并更新最小值栈
     *
     * @param val 要压入栈的元素
     */
    public void push(int val) {
        if (min_stack.isEmpty()) {
            min_stack.push(val); // 当前最小栈为空时，直接压入当前元素
        } else if (min_stack.peek() > val) {
            min_stack.push(val); // 当前元素小于最小值时，更新最小值栈
        } else {
            min_stack.push(min_stack.peek()); // 当前元素不小于最小值时，保持最小值栈不变
        }
        stack.push(val); // 压入正常栈
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素的值
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取栈中的最小元素
     *
     * @return 栈中的最小元素的值
     */
    public int getMin() {
        return min_stack.peek();
    }
}
