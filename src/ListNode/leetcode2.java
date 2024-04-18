package ListNode;

public class leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 创建一个哨兵节点来方便链表操作
        ListNode cur = dummy; // cur指针用来遍历新链表
        int carry = 0; // 用于保存计算过程中的进位

        // 循环处理直到两个链表都遍历完且没有进位
        while (l1 != null || l2 != null || carry != 0) {
            // 为当前位的值加上两个链表当前节点的值和进位
            if (l1 != null) carry += l1.val;
            if (l2 != null) carry += l2.val;

            // 创建新节点保存当前位的和，并更新carry为新的进位
            cur = cur.next = new ListNode(carry % 10);
            carry /= 10;

            // 移动到下一个节点
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // 返回哨兵节点的下一个节点，即新链表的头节点

    }

    public static void main(String[] args) {
        new leetcode2().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
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
