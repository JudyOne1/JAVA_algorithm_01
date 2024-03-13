package ListNode;

public class leetcode24 {
    //1-2-3-4
    //2-1-4-3
    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            //0
            return null;
        }
        if (head.next == null){
            //1
            return head;
        }
        ListNode pre = head;//1
        ListNode change;

        change = head.next;//2

        ListNode temp = change.next;//3
        change.next = pre;//2-1
        head = change;
        //确保两组之间到链接
        ListNode prepre = pre;
        pre.next = temp;//2-1-3

        while (pre.next!=null){
            //2-1-3-4 移动到34
            prepre = pre;
            pre = pre.next;//3
            if (pre.next == null){
                //奇数
                return head;
            }
            change = pre.next;//4


            if (change.next != null){
                prepre.next = change;//链接两组 2-1-4
                temp = change.next;//5
                change.next = pre;//4-3
                pre.next = temp;//2-1-3
            }else {
                //到最后了
                prepre.next = change;//链接两组
                change.next = pre;
                pre.next = null;
                break;
            }
        }


        return head;




    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode head = listNode;
        listNode.next = new ListNode(5);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(6);
        listNode = listNode.next;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(2);
        System.out.println(swapPairs(head));

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
