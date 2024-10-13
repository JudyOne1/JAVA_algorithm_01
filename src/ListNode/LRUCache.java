package ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class LRUCache {
    class LRUCache1 {
        int capacity;
        HashMap<Integer,Node> map = new HashMap<>();
        class Node{
            int key,value;
            Node pre,next;
            Node(int key,int value){
                this.key = key;
                this.value = value;
            }
        }
        Node dummy = new Node(0,0);
        public LRUCache1(int capacity) {
            this.capacity = capacity;
            dummy.next = dummy;
            dummy.pre = dummy;
        }


        public int get(int key) {
            Node node = getNode(key);
            if(node == null){
                return -1;
            }else{
                return node.value;
            }
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if(node == null){
                Node newNode = new Node(key,value);
                map.put(key,newNode);
                put2First(newNode);
                if(map.size()>capacity){
                    map.remove(dummy.pre.key);
                    remove(dummy.pre);

                }
                return;
            }else{
                node.value = value;
                return;
            }
        }

        public void remove(Node node){
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }
        public Node getNode(int key){
            if(map.containsKey(key)){
                Node node = map.get(key);

                remove(node);
                put2First(node);

                return node;
            }else{
                return null;
            }

        }
        public void put2First(Node node){
            Node next = dummy.next;
            node.pre = dummy;
            node.next = next;
            next.pre = node;
            dummy.next = node;
        }
    }


    // 双向链表
    //Node,capacity,dummy,map
    //get,put,remove,getNode,pushFront
    //put->getNode->pushFront->remove(map & node)
    //getNode->remove(node)->pushFront
    private class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0); // 哨兵节点
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) { // 有这本书
            node.value = value; // 更新 value
            return;
        }
        node = new Node(key, value); // 新书
        keyToNode.put(key, node);
        pushFront(node); // 放在最上面
        if (keyToNode.size() > capacity) { // 书太多了
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode); // 去掉最后一本书
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) { // 没有这本书
            return null;
        }
        Node node = keyToNode.get(key); // 有这本书
        remove(node); // 把这本书抽出来
        pushFront(node); // 放在最上面
        return node;
    }

    // 删除一个节点（抽出一本书）
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    // 在链表头添加一个节点（把一本书放在最上面）
    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

}