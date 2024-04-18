package ListNode;

import java.util.HashMap;

public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;

//        HashMap<Integer, ListNode> hashMap = new HashMap<>();
//        while (true){
//            hashMap.put(headA.val, headA);
//            if (headA.next == null){
//                break;
//            }
//            headA = headA.next;
//        }
//        while (true){
//            if (hashMap.containsKey(headB.val)){
//                ListNode same = hashMap.get(headB.val);
//                if (same == headB){
//                    return same;
//                }
//            }
//            if (headB.next == null){
//                break;
//            }
//            headB = headB.next;
//        }
//        return null;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
