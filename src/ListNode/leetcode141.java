package ListNode;

public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        // 初始化慢指针和快指针都指向头节点
        ListNode slow = head;
        ListNode fast = head;

        // 使用快慢指针法检测链表循环
        while (fast != null && fast.next != null) {
            slow = slow.next;        // 慢指针每次移动一个节点
            fast = fast.next.next;  // 快指针每次移动两个节点

            // 如果慢指针和快指针相遇，则链表存在循环
            if (slow == fast) {
                return true;
            }
        }

        // 如果快指针或快指针的下一个节点为null，则链表不存在循环
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
