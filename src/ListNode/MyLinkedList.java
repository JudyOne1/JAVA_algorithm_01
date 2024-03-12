package ListNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
//https://leetcode.cn/problems/design-linked-list/   存在bug,心态炸了不想搞了
public class MyLinkedList {

    Node head;
    int count;

    class Node{
        int val = -1;
        Node next;
    }

    public MyLinkedList() {
        head = new Node();
        head.next = null;
        count = 1;
    }

    public int get(int index) {
        if (count == 1 && head.val == -1){
            return -1;
        }
        if(count<=index){
            return -1;
        }
        Node helper = head;
        for (int i = 0; i <= index; i++) {
            if (i == index){
                return helper.val;
            }
            helper = helper.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        if (count == 1 && head.val == -1){
            head.val = val;
            return;
        }
        Node newHead = new Node();
        newHead.val = val;
        newHead.next = head;
        head = newHead;
        count++;
    }

    public void addAtTail(int val) {
        if (count == 1 && head.val == -1){
            head.val = val;
            return;
        }
        Node helper = head;
        Node newTail = new Node();
        newTail.val = val;
        while (helper.next != null){
            helper = helper.next;
        }
        helper.next = newTail;
        count++;
    }

    public void addAtIndex(int index, int val) {
        if(count<index){
            return;
        }
        if (count == 1 && index == 0 && head.val == -1){
            head.val = val;
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        if (index == count){
            addAtTail(val);
            return;
        }
        if (index > count){
            return;
        }
        Node helper = head;
        Node newAtIndex = new Node();
        newAtIndex.val = val;
        for (int i = 0; i <= index; i++) {
            if (i == index-1){
                //到了
                Node afterIndex = helper.next;
                helper.next = newAtIndex;
                newAtIndex.next = afterIndex;
                count++;
            }
            helper = helper.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0){
            head = head.next;
            count--;
            return;
        }
        if (index == 1 && count == 2){
            head.next = null;
            count--;
            return;
        }
        if (index<count){
            Node helper = head;
            for (int i = 0; i <= index; i++) {
                if (index == count){
                    //删除最后一个
                    if (i == index-1){
                        helper.next = null;
                        count--;
                        return;
                    }
                }
                if (i == index-1){
                    //到了
                    helper.next = helper.next.next;
                    count--;
                    return;
                }
                helper = helper.next;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);//1-2-7
        myLinkedList.addAtIndex(3,0);//1-2-7-0
        myLinkedList.deleteAtIndex(2);//1-2-0
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);//6-1-2-0-4
        System.out.println(myLinkedList.get(4));//4



    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

