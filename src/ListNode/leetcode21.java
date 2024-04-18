package ListNode;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 创建一个哨兵节点，简化链表合并的逻辑
        ListNode cur = dummy; // cur 指针用来指向新链表的尾节点

        // 遍历两个链表，将较小值的节点依次加入新链表的尾部
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 当list1的值较小，将其加入到新链表
                list1 = list1.next; // 移动list1指针
            } else {
                cur.next = list2; // 当list2的值较小，将其加入到新链表
                list2 = list2.next; // 移动list2指针
            }
            cur = cur.next; // 移动新链表的尾指针
        }

        // 将剩余未遍历完的链表直接拼接到新链表的尾部
        cur.next = list1 != null ? list1 : list2;

        return dummy.next; // 返回合并后链表的头节点

    }

    static class ListNode {
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
