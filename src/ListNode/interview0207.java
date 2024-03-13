package ListNode;

import java.util.ArrayList;

public class interview0207 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null||headB == null){
            return null;
        }
        //准备一个容器,将地址保存进去
        ListNode helperA = headA;
        ListNode helperB = headB;
        ArrayList<ListNode> listLocal = new ArrayList<>();
        while (helperA != null){
            listLocal.add(helperA);
            helperA = helperA.next;
        }
        ListNode temp;
        //循环获取容器元素地址并且进行比较
        for (ListNode node : listLocal) {
            helperB = headB;
            while (helperB != null){
                temp = helperB;
                if (temp.equals(node)){
                    return node;
                }
                helperB = helperB.next;
            }
        }
        return null;

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val;this.next = null; }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(3);
        ListNode headA = listNode1;
        ListNode headB = listNode2;
        listNode1.next = new ListNode(9);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(1);
        listNode1 = listNode1.next;
        ListNode connect = new ListNode(2);
        headB.next = connect;
        listNode1.next = connect;
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(4);


        System.out.println(getIntersectionNode(headA,headB));
    }
}
