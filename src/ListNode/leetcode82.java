package ListNode;

public class leetcode82 {

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;//拉进一格
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val)
                while (cur.next != null && cur.next.val == val)
                    cur.next = cur.next.next;
            else
                cur = cur.next;
        }
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
