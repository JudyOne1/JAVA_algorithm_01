package ListNode;


public class leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        //空链表
        if (head == null){
            return head;
        }

        //执行删除
        ListNode helper = head;
        while (helper.next != null){

            //本身是需要删除的
            if (head.val == val && head.next != null){
                head = head.next;
                helper = head;
            }else if (head.val == val && head.next == null){
                return null;
            }else if (helper.next.val == val){
                //本身不需要删除，next需要删除
                helper.next = helper.next.next;
            }else {
                helper = helper.next;
            }
            //到最后一个了
            if (helper.next == null){
                break;
            }
            //往后移动

        }

        //只有一个值的链表
//        if (head.val == val){
//            return head = null;
//        }
        return head;
    }
    public ListNode removeElements1(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;
        while (true){
            if (cur == null){
                break;
            }
            temp = cur.next;
            cur.next = pre;//反转
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
