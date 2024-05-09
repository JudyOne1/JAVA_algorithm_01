package ListNode;

import java.util.HashMap;

public class MyLRU {

    class Node {
        int key, value;
        Node pre, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    int capacity;
    Node dummy = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap<>();

    public MyLRU(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.pre = dummy;
    }

    public int get(int key) {
        Node node = find(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = find(key);
        if (node != null) { // 有这本书
            node.value = value; // 更新 value
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        putFront(node);
        if (map.size() > capacity) {
            Node lastOne = dummy.pre;
            map.remove(lastOne.key);
            remove(lastOne);
        }
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public Node find(int k) {
        if (!map.containsKey(k)) {
            return null;
        }
        Node node = map.get(k);
        remove(node);
        putFront(node);

        return node;
    }

    public void putFront(Node node) {
        node.pre = dummy;
        node.next = dummy.next;
        node.pre.next = node;
        node.next.pre = node;
    }


}
