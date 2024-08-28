package ListNode;


import java.util.*;

public class leetcode148 {
    public ListNode sortList5(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList5(head);
        ListNode right = sortList5(temp);
        //归并
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                newHead.next = left;
                left = left.next;

            } else {
                newHead.next = right;
                right = right.next;
            }
            newHead = newHead.next;
        }
        newHead.next = left == null ? right : left;
        return dummy.next;
    }

    public ListNode sortList4(ListNode head) {//二分
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList4(head);
        ListNode right = sortList4(temp);
        //归并
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                newHead.next = left;
                left = left.next;
                newHead = newHead.next;
            } else {
                newHead.next = right;
                right = right.next;
                newHead = newHead.next;
            }
        }
        newHead.next = left == null ? right : left;
        return dummy.next;


    }

    public ListNode sortList3(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        //快慢指针找中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList3(head);
        ListNode right = sortList3(temp);
        //归并
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                newHead.next = left;
                left = left.next;
                newHead = newHead.next;
            } else {
                newHead.next = right;
                right = right.next;
                newHead = newHead.next;
            }
        }
        newHead.next = left == null ? right : left;
        return dummy.next;
    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中点
        ListNode tmp = slow.next;
        slow.next = null;
        //归并递归
        ListNode left = sortList2(head);
        ListNode right = sortList2(tmp);

        //归并排序
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<Integer, List<ListNode>> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.putIfAbsent(cur.val, new ArrayList<>());
            map.get(cur.val).add(cur);
            cur = cur.next;
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int value : list) {
            for (ListNode node : map.get(value)) {
                tail.next = node;
                tail = tail.next;
            }
        }
        tail.next = null;
        return dummy.next;
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
