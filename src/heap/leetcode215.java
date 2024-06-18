package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode215 {
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }



















    public int findKthLargest1(int[] nums, int k) {
        //先保存K个值，不断弹出最小值即可
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();   // 将数组加入小顶堆，堆中维护当前值最大的k个数
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();   // 堆中元素超过k个，弹出最小的那个
            }
        }
        return pq.peek();    // 最后堆顶的即为第k大的数
    }
}
