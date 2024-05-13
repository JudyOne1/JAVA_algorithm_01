package ListNode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class leetcode148 {
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            map.put(cur.val, cur);
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1){
                map.get(list.get(i)).next = null;
                break;
            }
            map.get(list.get(i)).next = map.get(list.get(i+1));

        }
        return map.get(list.get(0));
    }
    public ListNode sortList(ListNode head) {
        // 使用哈希表将链表中的节点按值分组，同一值的节点组成一个子链表
        Map<Integer, List<ListNode>> groupMap = new HashMap<>();

        // 遍历链表，将每个节点及其值存入对应的子链表中
        for (ListNode cur = head; cur != null; cur = cur.next) {
            int val = cur.val;
            groupMap.computeIfAbsent(val, k -> new ArrayList<>()).add(cur);
        }

        // 将哈希表的键（即链表中的唯一值）存入优先队列，按照升序排列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(groupMap.keySet());

        // 创建新的链表，用于存放排序后的节点
        ListNode newHead = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = newHead;

        // 遍历优先队列，按照排序顺序将节点连接到新链表上
        while (!priorityQueue.isEmpty()) {
            int val = priorityQueue.poll();
            List<ListNode> nodeList = groupMap.get(val);

            // 将当前值的所有节点按原顺序连接到新链表上
            for (ListNode node : nodeList) {
                newHead.next = node;
                newHead = newHead.next;
            }
        }

        // 设置新链表的末尾节点
        newHead.next = null;

        // 返回新链表的第二个节点，即排好序的链表的头节点
        return dummy.next.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
