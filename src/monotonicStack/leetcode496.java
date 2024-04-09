package monotonicStack;

import java.util.Stack;

public class leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n]; // 用于存放结果
        int[] nums2Greater = new int[m]; // 临时数组，用于存储nums2中每个元素的下一个更大元素
        Stack<Integer> stack = new Stack<>(); // 单调栈，用于找到更大元素
        // 遍历nums2，使用栈找到每个元素的下一个更大元素
        for (int i = m - 1; i >= 0; i--) {
            // 如果栈不为空且栈顶元素小于当前nums2的元素，则弹出栈顶元素，直到栈为空或者栈顶元素大于当前nums2的元素
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            // 如果栈为空，则表示当前nums2的元素没有比它大的元素；否则，栈顶元素就是第一个比它大的元素
            if (stack.isEmpty()) {
                nums2Greater[i] = -1;
            } else {
                nums2Greater[i] = stack.peek();
            }
            stack.push(nums2[i]); // 将当前nums2的元素入栈
        }
        // 遍历nums1，查找每个元素在nums2Greater中的对应值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) { // 如果找到匹配的元素，则将对应的下一个更大元素存入结果数组
                    res[i] = nums2Greater[j];
                    break;
                }
            }
        }
        return res;
    }
}
