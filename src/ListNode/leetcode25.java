package ListNode;

public class leetcode25 {
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        int count = 0;
        while (p0.next != null) {
            p0 = p0.next;
            count++;
        }
        p0 = dummy;
        ListNode cur = head;
        ListNode pre = null;
        for (int i = 0; i < count/k; i++) {
            for (int j = 0; j < k; j++) {
                //p0 | pre - cur - nxt |
                //   |         pre | cur
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode p0next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = p0next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next)
            ++n; // 统计节点个数

        ListNode dummy = new ListNode(0, head), p0 = dummy;
        ListNode pre = null, cur = head;
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; ++i) { // 同 92 题
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            // 见视频
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表节点个数
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next)
            ++count;

        // 使用虚拟头节点方便操作
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        ListNode pre = null, cur = head;

        // 遍历链表，每次处理一个长度为 k 的子列表
        for (int i = 0; i < count / k; ++i) {
            // 翻转子列表
            for (int j = 0; j < k; ++j) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            // 将翻转后的子列表连接到原链表的适当位置
            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }

        // 返回翻转后的链表的头节点
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
