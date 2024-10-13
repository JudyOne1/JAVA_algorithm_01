package ListNode;

public class leetcode92 {
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        //找到left的位置，翻转left到right的链表，整体翻转
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        int count = 1;
        ListNode p0 = dummy;
        while (count < left){
            first = first.next;
            p0 = p0.next;
            count++;
        }
        //p0 - first - pre -cur
        count = 0;
        ListNode pre = null;
        ListNode cur = first;
        while (count < right-left+1){
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
            count++;
        }
        ListNode p0Head = p0.next;
        p0Head.next = cur;
        p0.next = pre;

        return dummy.next;

    }








    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 0; i < left- 1; i++) {
            cur = cur.next;
        }
        ListNode leftPrev = cur;
        ListNode rightNext = cur.next;
        ListNode prev = null;
        cur = cur.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        leftPrev.next = prev;
        rightNext.next = cur;
        return dummy.next;
    }



    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        //找到第一个
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null, cur = p0.next;
        //反转left到right
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
