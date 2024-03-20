package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode222 {
    /**
     * 计算二叉树中的节点数。
     *
     * @param root 二叉树的根节点
     * @return 二叉树中节点的总数
     */
    public int countNodes(TreeNode root) {
        // 如果根节点为空，树中节点数自然为0
        if (root == null) return 0;
        // 使用队列来进行层次遍历，初始化时将根节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0; // 用于记录节点总数
        // 当队列不为空时，持续遍历
        while (!queue.isEmpty()) {
            // 每层遍历开始前记录当前层的节点数
            int size = queue.size();
            // 遍历当前层的所有节点
            while (size-- > 0) {
                TreeNode cur = queue.poll(); // 出队并处理当前节点
                result++; // 遇到一个节点，总数加1
                // 如果当前节点有左子节点，将其入队
                if (cur.left != null) queue.offer(cur.left);
                // 如果当前节点有右子节点，将其入队
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return result; // 返回节点总数
    }


    static class TreeNode {
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
