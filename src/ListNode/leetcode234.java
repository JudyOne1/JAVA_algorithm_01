package ListNode;

import java.util.ArrayList;

public class leetcode234 {
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
