package ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode138 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();

        // 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        // 构建新链表的 next 和 random 指向
        while(cur != null) {
            if (cur.next != null) {
                map.get(cur).next = map.get(cur.next);
            }
            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }

        // 返回新链表的头节点
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
