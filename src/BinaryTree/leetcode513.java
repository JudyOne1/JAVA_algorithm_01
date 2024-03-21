package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 层序遍历的最后一层的第一个元素即为该二叉树的最底层最左边节点。
 */
public class leetcode513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null){
            return root.val;
        }
        // 用于存储结果的列表
        ArrayList<List<Integer>> resList = new ArrayList<List<Integer>>();
        // 使用队列进行层级遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 将根节点入队列

        // 当队列不为空时，持续进行层级遍历
        while (!queue.isEmpty()) {
            // 当前层的节点列表
            List<Integer> itemList = new ArrayList<Integer>();
            int len = queue.size(); // 当前层的节点数量

            // 遍历当前层的所有节点
            while (len > 0) {
                TreeNode tmpNode = queue.poll(); // 取出队列中的节点
                itemList.add(tmpNode.val); // 将节点值添加到当前层的节点列表中

                // 如果节点有左孩子，则将其入队列
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                // 如果节点有右孩子，则将其入队列
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--; // 当前层节点数量减一
            }

            // 将当前层的节点列表添加到结果列表中
            resList.add(itemList);
        }
        return resList.get(resList.size() - 1).get(0);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
