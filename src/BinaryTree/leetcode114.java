package BinaryTree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class leetcode114 {
    //使用哈希表存储前序遍历结果
    public void flatten(TreeNode root) {
        if (root == null) { // 如果根节点为空，则直接返回，无需操作
            return;
        }
        LinkedHashMap<TreeNode, TreeNode> map = new LinkedHashMap<>(); // 使用LinkedHashMap保持插入顺序
        dfs(root, map); // 深度优先搜索，填充哈希表

        root.left = null; // 将根节点的左子节点置为null，准备连接右子树

        Set<Map.Entry<TreeNode, TreeNode>> entries = map.entrySet(); // 获取哈希表的entry集合

        entries.remove(entries.iterator().next()); // 移除根节点的映射，避免多出一个节点

        for (Map.Entry<TreeNode, TreeNode> entry : entries) { // 遍历剩余的节点
            root.right = entry.getValue(); // 将当前节点的右子节点指向遍历到的节点
            root.left = null; // 确保左子节点为空，避免多叉树
            root = root.right; // 将当前节点更新为右子节点，为下一个节点做准备
        }

    }

    private void dfs(TreeNode root, LinkedHashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        map.put(root, new TreeNode(root.val));
        dfs(root.left, map);
        dfs(root.right, map);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
