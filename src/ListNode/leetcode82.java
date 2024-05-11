package ListNode;

public class leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            int val = current.next.val;
            if (current.next.val == current.next.next.val){
                while (current.next != null && current.next.val == val){
                    current.next = current.next.next;
                }
            }else {
                current = current.next;
            }
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
