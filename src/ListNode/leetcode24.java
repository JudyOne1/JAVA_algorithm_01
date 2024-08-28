package ListNode;

public class leetcode24 {


    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            // 0-1-2-3 -> 0-2-1-3
            node0.next = node2;
            node1.next = node3;
            node2.next = node1;

            node0 = node1;
            node1 = node3;

        }
        return dummy.next;
    }


    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0, head); // 用哨兵节点简化代码逻辑
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) { // 至少有两个节点
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            // 0-1-2-3 -> 0-2-1-3
            node0.next = node2; // 0 -> 2
            node2.next = node1; // 2 -> 1
            node1.next = node3; // 1 -> 3

            node0 = node1; // 下一轮交换，0 是 1
            node1 = node3; // 下一轮交换，1 是 3
        }
        return dummy.next; // 返回新链表的头节点

    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            // 链表为空，直接返回null
            return null;
        }
        if (head.next == null) {
            // 链表只有一个节点，直接返回该节点
            return head;
        }
        ListNode pre = head;// 记录当前节点的前一个节点
        ListNode change;

        change = head.next;// 记录要交换的节点

        ListNode temp = change.next;// 记录交换节点的后一个节点
        change.next = pre;// 将要交换的节点指向当前节点的前一个节点
        head = change;
        // 确保两组节点之间的链接
        ListNode prepre = pre;
        pre.next = temp;// 将当前节点的前一个节点指向交换节点的后一个节点

        while (pre.next != null) {
            // 移动到下一组节点进行交换
            prepre = pre;
            pre = pre.next;// 记录当前节点
            if (pre.next == null) {
                // 如果当前节点是链表末尾，结束循环
                return head;
            }
            change = pre.next;// 记录要交换的节点

            if (change.next != null) {
                // 交换节点并重新链接
                prepre.next = change;// 将当前节点的前一个节点指向要交换的节点
                temp = change.next;// 记录交换节点的后一个节点
                change.next = pre;// 将要交换的节点指向当前节点
                pre.next = temp;// 将当前节点指向交换节点的后一个节点
            } else {
                // 如果交换节点是链表末尾，进行特殊处理
                prepre.next = change;// 将当前节点的前一个节点指向要交换的节点
                change.next = pre;
                pre.next = null;
                break;
            }
        }


        return head;
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
