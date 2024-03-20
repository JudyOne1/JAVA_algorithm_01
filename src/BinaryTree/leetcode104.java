package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode104 {
    public int maxDepth(TreeNode root) {
        //使用层序遍历查看有多少层即可
        if (root == null) {
            return 0;
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
        return resList.size();
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
