package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode215 {
    public int findKthLargest3(int[] nums, int k) {
        int[] res = heapSort(nums);

        return res[res.length - k];
    }

    int[] heapSort1(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify1(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify1(nums, i, 0);

        }
        return nums;
    }

    private void heapify1(int[] nums, int len, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i){
            swap(nums,largest,i);
            heapify1(nums,len,largest);
        }
    }


    private int[] heapSort(int[] nums) {
        int len = nums.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify3(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify3(nums, i, 0);
        }

        return nums;
    }

    private void heapify3(int[] nums, int len, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, len, largest);
        }

    }

    public int findKthLargest2(int[] nums, int k) {
        sort(nums);
        return nums[nums.length - k];
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    void sort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int len, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, len, largest);
        }
    }


    public int findKthLargest1(int[] nums, int k) {
        //先保存K个值，不断弹出最小值即可
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();   // 将数组加入小顶堆，堆中维护当前值最大的k个数
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();   // 堆中元素超过k个，弹出最小的那个
            }
        }
        return pq.peek();    // 最后堆顶的即为第k大的数
    }
}
