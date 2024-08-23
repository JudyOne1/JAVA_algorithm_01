package stackAndList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class leetcode239 {

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        //保存下标
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[right]) {
                //非空且更小
                qmax.pollLast();
            }
            qmax.addLast(right);
            if (qmax.peekFirst() == right - k) {
                //移除过期元素
                qmax.pollFirst();
            }
            if (right - left + 1 == k) {
                //形成窗口了
                ans[left] = nums[qmax.peekFirst()];
                left++;
            }
        }
        return ans;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int R = 0; R < nums.length; R++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);

            if (qmax.peekFirst() == R - k) {
                qmax.pollFirst();
            }

            if (R >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int R = 0; R < nums.length; R++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);

            if (qmax.peekFirst() == R - k) {
                qmax.pollFirst();
            }
            if (R >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 验证输入的合法性
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        // 使用双向队列qmax来维护当前窗口内的最大值及其位置
        // 队列尾部保持从大到小的顺序，保证队列头部始终是当前窗口内的最大值
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1]; // 结果数组，存储每个窗口的最大值
        int index = 0; // 结果数组的索引

        // 遍历数组，维护qmax队列和结果数组
        for (int R = 0; R < nums.length; R++) {
            // 从队列尾部移除所有小于等于当前元素的值，保持队列从大到小的顺序
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R]) {
                qmax.pollLast();
            }
            // 将当前元素的位置添加到队列尾部
            qmax.addLast(R);

            // 如果队列的头部元素已经超出当前窗口的范围，则移除该元素
            if (qmax.peekFirst() == R - k) {
                qmax.pollFirst();
            }

            // 当遍历到第w个元素时，开始保存窗口的最大值到结果数组
            if (R >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}
