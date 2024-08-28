package ListNode;

import java.util.ArrayList;

public class leetcode234 {
    public boolean isPalindrome1(ListNode head) {
        // 找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表的后半部分翻转
        ListNode prev = null;
        ListNode curr = slow;
        while (curr!= null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 比较链表的前半部分和后半部分是否相等
        ListNode left = head;
        ListNode right = prev;
        while (right!= null) {
            if (left.val!= right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        // 将链表中的元素值存入ArrayList中
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 将ArrayList转换为Integer数组，便于使用双指针法进行比较
        Integer[] array = list.toArray(new Integer[list.size()]);

        // 使用双指针法，从数组两端向中间进行比较
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // 如果左右两边的元素不相等，则链表不是回文链表
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }

        // 遍历结束后仍未发现不相等元素，说明链表是回文链表
        return true;
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
