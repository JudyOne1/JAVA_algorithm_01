package ListNode;


import java.util.ArrayList;
import java.util.Collections;

public class leetcode206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode helper = head;
        //先存起来，倒序输出
        ArrayList<ListNode> list = new ArrayList<>();
        //保存到list中
        while (helper != null){
            list.add(helper);
            helper = helper.next;
        }
        //反转
        Collections.reverse(list);
        helper = new ListNode();
        ListNode helperHead = helper;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1){
                //到最后一个了
                helper.next = list.get(i);
                helper.next.next = null;
                break;
            }
            helper.next = list.get(i);
            helper = helper.next;
        }
        head = helperHead.next;
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        listNode.next = new ListNode(2);
        System.out.println(reverseList(head));

    }
     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
