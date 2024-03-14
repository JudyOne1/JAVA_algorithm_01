package ListNode;

import java.util.LinkedHashMap;

public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        //将节点到地址记下来，遍历head对比地址是否相同，相同则代表出现环
        //key为节点地址，value为从0自增到数字
        if (head == null){
            return null;
        }
        LinkedHashMap<ListNode,Integer > map = new LinkedHashMap<>();

        int count = 0;
        while(head != null){
            if (map.containsKey(head)){
                return head;
            }
            map.put(head,count++);
            head = head.next;
        }
        return null;


    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val;this.next = null; }
    }
}
