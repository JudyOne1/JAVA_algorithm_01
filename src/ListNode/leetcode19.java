package ListNode;

public class leetcode19 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0); // 使用虚拟节点作为头节点的前一个节点，简化操作
        dummyNode.next = head;

        ListNode fastIndex = dummyNode; // 快指针初始化
        ListNode slowIndex = dummyNode; // 慢指针初始化

        // 快指针先前进n步，使得快慢指针相差n个节点
        for (int i = 0; i <= n; i++){
            fastIndex = fastIndex.next;
        }

        // 快慢指针同时向前，直到快指针到达链表尾部
        while (fastIndex != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // 此时慢指针指向待删除节点的前一个节点
        // 删除节点操作
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next; // 返回更新后的链表头节点
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 只要快慢指针相差 n 个结点即可
        for (int i = 0; i <= n  ; i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
