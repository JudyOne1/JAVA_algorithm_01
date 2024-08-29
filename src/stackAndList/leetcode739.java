package stackAndList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode739 {
    /**
     * [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < cur){
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        if (!stack.isEmpty()){
            ans[stack.peek()] = 0;
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 创建一个数组用于存储结果，初始化为0
        int[] ans = new int[temperatures.length];
        // 使用栈来存储温度数组中较大温度的索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int curTemperature = temperatures[i];
            // 当栈不为空且栈顶的温度小于当前温度时，说明找到了一个需要等待的天数
            while (!stack.isEmpty() && temperatures[stack.peek()] < curTemperature) {
                // 计算等待天数并更新结果数组
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            // 将当前天的索引入栈
            stack.push(i);
        }
        // 处理栈中剩余的元素，即没有后一天温度大于它的天数，等待天数为0
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}
