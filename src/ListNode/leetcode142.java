package ListNode;

import java.util.LinkedHashMap;

public class leetcode142 {
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle(ListNode head) {
        //将节点到地址记下来，遍历head对比地址是否相同，相同则代表出现环
        //key为节点地址，value为从0自增到数字
        // 使用哈希表记录节点地址及其访问次数
        if (head == null) {
            return null;
        }
        LinkedHashMap<ListNode, Integer> map = new LinkedHashMap<>();

        int count = 0;
        while (head != null) {
            // 如果节点已存在于哈希表中，则说明发现环，返回该节点
            if (map.containsKey(head)) {
                return head;
            }
            // 记录节点及其访问次数
            map.put(head, count++);
            // 移动到下一个节点
            head = head.next;
        }
        // 链表中无环，返回null
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        //快慢指针法
        // 初始化快慢指针
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        // 使用快慢指针寻找环的入口
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 判断链表是否包含环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 快慢指针重新对齐，寻找环的起点
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        // 返回环的起点
        if (fast == slow) {
            return fast;
        } else {
            return null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
