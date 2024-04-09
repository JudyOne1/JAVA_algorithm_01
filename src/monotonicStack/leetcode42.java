package monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode42 {
    public int trap(int[] height) {
        int ans = 0; // 容纳的水量初始化为0
        Deque<Integer> stack = new ArrayDeque<>(); // 使用栈来存储数组索引【单调栈的逻辑】
        for (int i = 0; i < height.length; i++) {
            // 当栈不为空且当前位置的高度大于等于栈顶索引对应的高度时
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottomHeight = height[stack.pop()]; // 弹出栈顶元素，即最矮的柱子高度
                if (stack.isEmpty()) {
                    break; // 如果栈为空，说明已经处理完左侧所有的柱子，退出循环
                }
                int left = stack.peek(); // 获取最矮柱子 左侧 最近柱子的索引
                int right = i; // 最矮柱子 右侧 最近柱子的索引
                int h = Math.min(height[left], height[right]) - bottomHeight; // 计算最矮柱子与两旁柱子的高度
                ans += h * (right - left - 1); // 根据宽度和高度计算面积，加到总水量上【逐渐填平底部】
            }
            stack.push(i); // 将当前索引入栈，作为下一个柱子的位置
        }
        return ans; // 返回计算出的总水量
    }

    public static void main(String[] args) {
        new leetcode42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
