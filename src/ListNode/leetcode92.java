package ListNode;

public class leetcode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 使用虚拟节点dummy建立头节点的前驱，方便处理头节点变化的情况
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        // 定位到需要反转部分的前一个节点
        for (int i = 0; i < left - 1; ++i)
            p0 = p0.next;

        ListNode pre = null, cur = p0.next;
        // 反转指定范围内的节点
        for (int i = 0; i < right - left + 1; ++i) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        // 连接反转后的链表和剩余未反转的部分
        p0.next.next = cur;//链接后面的链表
        p0.next = pre;//链接前面的链表
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
