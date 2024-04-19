package ListNode;

public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表节点个数
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next)
            ++count;

        // 使用虚拟头节点方便操作
        ListNode dummy = new ListNode();
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

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
