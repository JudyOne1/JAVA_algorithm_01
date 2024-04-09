package monotonicStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode84 {
    public int largestRectangleArea(int[] heights) {
        // 获取每个位置左边和右边小于当前高度的索引数组
        int[][] nearLess = getNearLess(heights);
        int maxArea = 0; // 初始化最大面积为0

        // 遍历每个高度计算矩形面积
        for (int i = 0; i < heights.length; i++) {
            int left = nearLess[i][0];
            int right = nearLess[i][1];
            if (right == -1){
                right = heights.length;
            }
            int curArea = (right - left - 1) * heights[i];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea; // 返回最大面积
    }
    /**
     * 获取数组中每个元素的左边小于它的元素的索引和右边小于它的元素的索引。
     *
     * @param arr 输入的整数数组。
     * @return 一个二维数组，其中每个元素是一个长度为2的数组，第一个元素是左侧离i最近并且小于i元素的索引，第二个元素是右侧离i最近并且小于i元素的索引
     */
    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2]; // 定义结果数组
        Stack<List<Integer>> stack = new Stack<>(); // 使用栈来存储链表，使用List<Integer>的目的是保存重复值
        // 栈 由小到大 的顺序
        for (int i = 0; i < arr.length; i++) { // 遍历数组
            // 当栈不为空且栈顶元素对应的数值大于当前元素时，出栈处理
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop(); // 弹出链表
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1); // 获取左边小于当前元素的最后一个元素的索引
                // 为链表中的每个元素设置结果
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            // 当栈不为空且栈顶元素对应的数值等于当前元素时，将当前元素添加到栈顶链表中
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                // 当栈为空或栈顶元素对应的数值大于当前元素时，新建链表并将当前元素添加到栈中
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        // 处理栈中剩余的元素，这些元素的右边没有小于它们的元素
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop(); // 弹出链表
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1); // 获取左边小于当前元素的最后一个元素的索引
            // 为链表中的每个元素设置结果
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1; // 右边没有小于当前元素的元素
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new leetcode84().largestRectangleArea(new int[]{0,9});
    }

    public int largestRectangleArea1(int[] heights) {
        // 当数组为空或长度为0时，直接返回0，因为无法构成矩形
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0; // 记录最大面积
        Stack<Integer> stack = new Stack<Integer>(); // 使用栈来记录高度数组的索引【单调栈】

        // 遍历每个高度  【stack由小到大单调递增】
        for (int i = 0; i < heights.length; i++) {
            // 当栈不为空且当前高度小于等于栈顶索引对应的高度时，弹出栈顶元素
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int j = stack.pop(); // 弹出栈顶元素的索引
                int k = stack.isEmpty() ? -1 : stack.peek(); // 查看栈是否为空，若为空，则k为-1；否则，k为栈顶元素的索引
                // 计算当前矩形的面积，并更新最大面积
                int curArea = (i - k - 1) * heights[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i); // 将当前索引压入栈
        }

        // 处理栈中剩余的元素
        while (!stack.isEmpty()) {
            int j = stack.pop(); // 弹出栈顶元素的索引
            int k = stack.isEmpty() ? -1 : stack.peek(); // 和上面一样，查看栈是否为空
            // 计算以当前索引为右边界的最大矩形面积，并更新最大面积
            int curArea = (heights.length - k - 1) * heights[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea; // 返回最大面积
    }
}
