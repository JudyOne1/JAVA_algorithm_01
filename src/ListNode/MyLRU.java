package ListNode;

import java.util.HashMap;

public class MyLRU {

    class LRUCache1 {
        class Node {
            int key, value;
            Node pre, next;

            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        int cap;
        HashMap<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(0, 0);

        public LRUCache1(int capacity) {
            this.cap = capacity;
            dummy.next = dummy;
            dummy.pre = dummy;
        }

        Node findNode(int k) {
            if (!map.containsKey(k)) {
                return null;
            }
            Node node = map.get(k);
            remove(node);
            put2First(node);
            return node;
        }

        void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        void put2First(Node node) {
            Node next = dummy.next;
            node.pre = dummy;
            node.next = next;
            next.pre = node;
            dummy.next = node;
        }

        public int get(int key) {
            Node node = findNode(key);
            if (node == null) {
                return -1;
            } else {
                return node.value;
            }
        }

        public void put(int key, int value) {
            Node node = findNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            Node cur = new Node(key, value);
            put2First(cur);
            map.put(key, cur);
            if (map.size() > cap) {
                map.remove(dummy.pre.key);
                remove(dummy.pre);
            }


        }

    }


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
