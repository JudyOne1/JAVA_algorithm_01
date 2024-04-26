package map;

class Trie {
    class Node {
        Node[] children;     // 子节点列表
        boolean isEnd;       // 标记是否尾节点

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
    private Node root;     // 根节点

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;      // 从根节点开始构造这个word对应的路径节点
        int n = word.length();
        for (int i = 0; i < n; i++) {
            // 将当前字符添加到当前节点对应的子节点位置，然后递归更新
            int id = word.charAt(i) - 'a';
            if (node.children[id] == null) {
                node.children[id] = new Node();
            }
            node = node.children[id];
        }
        node.isEnd = true; // 最后一个节点的isEnd置为true，表示一个完整的字符串
    }

    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd;  // 返回不为空且节点标记为尾节点，则包含word这个完整的字符串

    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null; // 返回不为空，则包含了prefix前缀
    }

    /**
     * 查找字典树是否包含word前缀
     */
    private Node searchPrefix(String word) {
        Node node = root;  // 从根节点依次开始匹配每个字符
        int n = word.length();
        for (int i = 0; i < n; i++) {
            node = node.children[word.charAt(i) - 'a']; // 根据当前字符获取对应的子节点
            if (node == null) {
                return null;     // 只要当前节点为空，则不包含这个字符串，直接返回空指针
            }
        }
        return node;    // 否则匹配成功返回node
    }
}


