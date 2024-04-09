package monotonicStack;

import java.util.Stack;

public class leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        // 创建一个长度为nums.length两倍的数组，用于复制nums并进行环形操作
        int[] doubleNums = new int[nums.length * 2];
        // 复制nums数组到doubleNums数组的前半部分和后半部分，实现环形复制
        for (int i = 0; i < nums.length; i++) {
            doubleNums[i] = nums[i];
            doubleNums[i + nums.length] = nums[i];
        }

        int[] res = new int[nums.length]; // 准备存放结果的数组
        Stack<Integer> stack = new Stack<>(); // 使用栈来进行元素比较和记录

        // 从数组末尾开始遍历，这样可以保证每个元素都只会被考虑一次
        for (int i = doubleNums.length - 1; i >= 0; i--) {
            // 当栈不为空且栈顶元素小于等于当前遍历的元素时，将栈顶元素出栈，直至栈为空或栈顶元素大于当前元素
            while (!stack.isEmpty() && stack.peek() <= doubleNums[i]) {
                stack.pop();
            }

            // 如果栈为空，表示没有找到比当前元素更大的数，则在结果数组中对应位置记录-1
            if (stack.isEmpty()) {
                res[i%nums.length] = -1;
            } else {
                // 否则，栈顶元素即为当前元素的下一个更大元素
                res[i%nums.length] = stack.peek();
            }
            // 将当前元素入栈，以便于处理之后的元素
            stack.push(doubleNums[i]);
        }
        return res;

    }
}
