package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetcode129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        x = x * 10 + root.val;
        if (root.left == root.right) { // root 是叶子节点
            return x;
        }
        return dfs(root.left, x) + dfs(root.right, x);
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
