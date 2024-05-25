package heap;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    /**
     * 先统一把元素插入B，然后此时B基于大顶堆的结构特性，
     * 可能会将该元素作为新的堆顶元素，此时再执行插入A的操作就相当于此前在B处过渡了一下，
     * 最终还是会插入A ，用堆的自身调整操作替换了比较大小的操作。
     */
    public void addNum(int num) {
        if (A.size() != B.size()) {
            //需要往 B 加元素
            A.add(num); // 将新数添加到A中，根据小顶堆的特性，堆顶元素是最小的
            B.add(A.poll()); // 从A中取出最小值并添加到B中，保持平衡
        } else {
            //需要往 A 加元素
            B.add(num); // 将新数添加到B中，根据大顶堆的特性，堆顶元素是最大的
            A.add(B.poll()); // 从B中取出最大值并添加到A中，保持平衡
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}