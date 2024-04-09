package monotonicStack;

import java.util.Stack;

public class leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length; // 数组的长度
        int[] ans = new int[N]; // 结果数组，存储每一天距离未来更高温度的天数
        Stack<Integer> stack = new Stack<>(); // 使用栈来存储数组索引
        stack.push(N - 1); // 先将最后一个元素的索引入栈，从后往前遍历

        for (int i = N - 1; i >= 0; i--) {
            int temp = temperatures[i]; // 当前遍历的温度

            // 如果栈不为空且当前温度不高于栈顶索引对应的温度，则持续出栈
            while (!stack.isEmpty() && temp >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // 如果栈不为空，说明找到了一个未来温度更高的天数，计算距离并存入结果数组
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }

            stack.push(i); // 将当前索引入栈
        }
        return ans;
    }
}
